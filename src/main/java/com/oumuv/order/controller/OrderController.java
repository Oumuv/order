package com.oumuv.order.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import com.oumuv.order.commons.Page;
import com.oumuv.order.entitys.OrderAndPro;
import com.oumuv.order.entitys.OrderEntity;
import com.oumuv.order.entitys.Person;
import com.oumuv.order.entitys.ProductEntity;
import com.oumuv.order.service.OrderService;
import com.oumuv.order.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.*;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "createAt");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order,order2);
        Pageable pageable = new PageRequest(0, 50, sort);
//        Pageable pageable1 = new QPageRequest()
        Iterable<OrderEntity> all = orderService.findAll(pageable);
        map.put("items", all);
        return "orderlist";
    }

    @ApiOperation(value ="加载添加订单页面",notes ="",httpMethod = "GET")
    @RequestMapping("add")
    public String add() {
        return "order_add";
    }


    @ApiOperation(value ="导出数据页面",notes ="",httpMethod = "GET")
    @RequestMapping("export")
    public String export() {
        return "order_export";
    }

    @RequestMapping("export/dates")
    public void exportByDate(@DateTimeFormat(pattern = "yyyy-MM-dd")Date start, @DateTimeFormat(pattern = "yyyy-MM-dd")Date end, HttpServletResponse response) throws IOException {
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;filename=test.xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        List<OrderEntity> all = orderService.findAll(new Specification<OrderEntity>() {

            @Override
            public Predicate toPredicate(Root<OrderEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Date> createAt = root.get("createAt");

                Predicate between = criteriaBuilder.between(createAt, start, end);
                return between;
            }
        });
        List<Map<String,Object>> orderVOS = entity2VO(all);
        ExcelWriter writer = ExcelUtil.getWriter(true);
        CreationHelper creationHelper = writer.getWorkbook().getCreationHelper();
        StyleSet styleSet = writer.getStyleSet();
        CellStyle cellStyleForDate = styleSet.getCellStyleForDate();
        cellStyleForDate.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy年MM月dd日"));
        writer.write(orderVOS);
        writer.flush(outputStream);
        writer.close();
        outputStream.close();

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

    private List<Map<String,Object>> entity2VO(List<OrderEntity> list) {
        List<Map<String,Object>> result = new LinkedList<>();
        for (OrderEntity obj : list) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("日期",obj.getCreateAt());
            map.put("地区",obj.getPerson().getFromArea());
            map.put("姓名",obj.getPerson().getuName());
            map.put("奖金发放状态", obj.getStatus() == 0 ? "未发放" : "已发放");
            map.put("奖金",obj.getAward());
            map.put("订单",getProductsStr(obj.getProducts()));
            result.add(map);
        }
        return result;
    }

    private String getProductsStr(Set<OrderAndPro> set) {
        Iterator<OrderAndPro> iterator = set.iterator();
        StringBuffer result = new StringBuffer();

        while (iterator.hasNext()) {
            OrderAndPro next = iterator.next();
            result.append(next.getPid().getPname() + "/" + next.getQuantity()+" ");
        }
        return result.toString();
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
        private int status;//奖金发放状态，0：未发放，5已发放

        private OrderEntity orderEntity;

        private Map<ProductEntity, Integer> pros = new HashMap<>();
        private String products;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public String getProducts() {
            return products;
        }

        public void setProducts(String products) {
            this.products = products;
        }
    }

}
