package com.oumuv.order.service;

import com.oumuv.order.entitys.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Set;

/***
 *<pre>
 *
 *</pre>
 * @interface: ProductService
 * @auther: oyf
 * @date: 2019-03-05 16:56
 * @version : V1.0
 */
public interface ProductService extends JpaRepository<ProductEntity,Long> {

    @Query(value = "from ProductEntity where deleted=0 and pname like CONCAT('%',:pname,'%') and startDate<=:nowDate and endDate>=:nowDate")
    Set<ProductEntity> findAllFN(String pname, Date nowDate);

}
