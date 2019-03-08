package com.oumuv.order.controller;

import com.oumuv.order.commons.Page;
import com.oumuv.order.entitys.OrderEntity;
import com.oumuv.order.entitys.ProductEntity;
import com.oumuv.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("orderlist")
    public String orderlist(ModelMap map) {
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

    @PutMapping("/save")
    @ResponseBody
    @ApiOperation(value ="保存订单")
    public Page save(OrderVO entity ) {
        int t = 0;
        try {
            if (null == entity.getId()) {
//                entity.setCreateAt(new Date());
            } else {
//                entity.setUpdateAt(new Date());
            }
            return new Page(/*orderService.save(entity)*/);
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
        private Date createAt;
        private Boolean deleted;
        private Double award;//奖励金额

        private OrderEntity orderEntity;

        private Map<ProductEntity, Integer> pros = new HashMap<>();

        private Map<String, Integer> map = new HashMap<>();//k:proID,v:count


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

        public OrderEntity getOrderEntity() {
            return orderEntity;
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

        public Map<String, Integer> getMap() {
            return map;
        }

        public void setMap(Map<String, Integer> map) {
            this.map = map;
        }
    }

}
