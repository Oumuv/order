package com.oumuv.order.service;

import com.oumuv.order.entitys.OrderEntity;
import com.oumuv.order.entitys.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/***
 *<pre>
 *
 *</pre>
 * @interface: OrderService
 * @auther: oyf
 * @date: 2019-03-05 16:56
 * @version : V1.0
 */
public interface OrderService extends JpaRepository<OrderEntity,Long> , JpaSpecificationExecutor<OrderEntity> {

    /**
     * 查询商品销售总数
     * @return
     */
    @Query(value = "SELECT p.pname,sum(op.quantity) FROM t_product p JOIN order_product op ON op.pid_id=p.id WHERE p.deleted=0 GROUP BY p.id",nativeQuery = true)
    List<Object[]> getCollect();

    /**
     * 获取近30天的销售数量
     * @return
     */
    @Query(value = "SELECT datas.DAY '时间',count(o.create_at) '数量' FROM (SELECT @cdate \\:=DATE_ADD(@cdate,INTERVAL-1 DAY) DAY FROM (SELECT @cdate \\:=DATE_ADD((SELECT DATE_FORMAT(now(),'%Y-%m-%d')),INTERVAL+1 DAY) FROM t_order) t0 LIMIT 30) datas LEFT JOIN t_order o ON o.create_at=datas.DAY GROUP BY datas.DAY ORDER BY datas.DAY ASC",nativeQuery = true)
    List<Object[]> get30DatesData();

    @Query(value = "SELECT per.from_area,per.u_name,count(o.id) '订单数',sum(o.award) '奖金' FROM t_person per INNER JOIN t_order o ON o.person_id=per.id WHERE o.create_at IN (SELECT dates.DAY FROM (SELECT @cdate \\:=DATE_ADD(@cdate,INTERVAL-1 DAY) DAY FROM (SELECT @cdate \\:=DATE_ADD((SELECT DATE_FORMAT(now(),'%Y-%m-%d')),INTERVAL+1 DAY) FROM t_order) t0 LIMIT 30) AS dates) GROUP BY per.u_name,per.from_area  ORDER BY sum(o.award) desc",nativeQuery = true)
    List<Object[]> get30DatesDateByUname();

    /**
     * 根据状态查询 OrderEntity
     * @param status
     * @return
     */
    @Query(value = "from OrderEntity where status=?1")
    List<OrderEntity> findByStatus(int status);




}
