package com.oumuv.order.controller;

import com.oumuv.order.commons.Page;
import com.oumuv.order.entitys.OrderAndPro;
import com.oumuv.order.entitys.OrderEntity;
import com.oumuv.order.entitys.Person;
import com.oumuv.order.entitys.ProductEntity;
import com.oumuv.order.service.OrderService;
import com.oumuv.order.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/***
 *<pre>
 *  订单controller
 *</pre>
 * @ClassName: OrderController
 * @Auther: oyf
 * @Date: 2019-03-07 11:57
 * @version : V1.0
 */
@Controller
@RequestMapping("order")
@Api
public class OrderController extends AbstractController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PersonService personService;


    @GetMapping("orderlist")
    public String orderlist(ModelMap map) {
        Sort sort = new Sort(Sort.Direction.ASC,"createAt");
//        Pageable pageable = new PageRequest(0, 5, sort);
//        Pageable pageable1 = new QPageRequest()
        Iterable<OrderEntity> all = orderService.findAll();
        map.put("items", all);
        return "orderlist";
    }

    @ApiOperation(value ="加载添加订单页面",notes ="",httpMethod = "GET")
    @RequestMapping("add")
    public String add() {
        return "order_add";
    }

    @ApiOperation(value ="加载修改订单页面",notes ="",httpMethod = "GET")
    @RequestMapping(value = "updata/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public String updata(@PathVariable("id")String id, ModelMap map) {
        Optional<OrderEntity> byId = orderService.findById(Long.parseLong(id));
        OrderEntity entity = byId.get();
        map.put("item", entity);
        return "order_updata";
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    @ApiOperation(value ="删除订单")
    public Page del(@PathVariable("id") String id) {
        try {
            orderService.deleteById(Long.parseLong(id));
            return new Page();
        }catch (Exception e){
            return new Page(e,"500",e.getMessage());
        }
    }

    @RequestMapping("/save")
    @ResponseBody
    @ApiOperation(value ="保存订单")
    public Page save(OrderVO vo ) {
        OrderEntity orderEntity = vo.getOrderEntity();
        Person person;
        Long uid = vo.getUid();
        if (uid != null) {//不为空
            person = personService.findById(uid).get();
        } else {
            person = new Person(vo.getuName(), vo.getFromArea());
        }

        orderEntity.setPerson(person);
        try {
            if (null == orderEntity.getId()) {
//                entity.setCreateAt(new Date());
            } else {
//                entity.setUpdateAt(new Date());
            }
            return new Page(orderService.save(orderEntity));
        }catch (Exception e){
            e.printStackTrace();
            return new Page(e,"500","保存失败");
        }
    }

    /**
     * 订单VO
     */
    public class OrderVO {
        private Long uid;
        private String uName;//名字
        private String fromArea;//地区

        private Long id;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date createAt;
        private Boolean deleted;
        private Double award;//奖励金额

        private OrderEntity orderEntity;

        private Map<ProductEntity, Integer> pros = new HashMap<>();

        List<Integer> pids;

        List<Integer> counts;

        public OrderEntity getOrderEntity() {
            orderEntity = new OrderEntity();

            orderEntity.setAward(award);
            orderEntity.setCreateAt(createAt);

            Set<OrderAndPro> orderAndProList = new HashSet<>();
            int index = 0;
            for (Integer id : pids) {
                OrderAndPro oap = new OrderAndPro();
//                oap.setOid(orderEntity);
                oap.setPid(new ProductEntity(id.longValue()));
                oap.setQuantity(counts.get(index++));
                orderAndProList.add(oap);
            }
            orderEntity.setProducts(orderAndProList);
            return orderEntity;
        }

        public List<Integer> getPids() {
            return pids;
        }

        public void setPids(List<Integer> pids) {
            this.pids = pids;
        }

        public List<Integer> getCounts() {
            return counts;
        }

        public void setCounts(List<Integer> counts) {
            this.counts = counts;
        }

        public Long getUid() {
            return uid;
        }

        public void setUid(Long uid) {
            this.uid = uid;
        }

        public String getuName() {
            return uName;
        }

        public void setuName(String uName) {
            this.uName = uName;
        }

        public String getFromArea() {
            return fromArea;
        }

        public void setFromArea(String fromArea) {
            this.fromArea = fromArea;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Date getCreateAt() {
            return createAt;
        }

        public void setCreateAt(Date createAt) {
            this.createAt = createAt;
        }

        public Boolean getDeleted() {
            return deleted;
        }

        public void setDeleted(Boolean deleted) {
            this.deleted = deleted;
        }

        public Double getAward() {
            return award;
        }

        public void setAward(Double award) {
            this.award = award;
        }

        public void setOrderEntity(OrderEntity orderEntity) {
            this.orderEntity = orderEntity;
        }

        public Map<ProductEntity, Integer> getPros() {
            return pros;
        }

        public void setPros(Map<ProductEntity, Integer> pros) {
            this.pros = pros;
        }
    }

}
