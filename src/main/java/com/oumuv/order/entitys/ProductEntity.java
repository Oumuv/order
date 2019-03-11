package com.oumuv.order.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/***
 *<pre>
 *  商品
 *</pre>
 * @ClassName: ProductEntity
 * @Auther: oyf
 * @Date: 2019-03-02 23:46
 * @version : V1.0
 */
@Entity
@Table(name = "t_product")
@SQLDelete(sql = "update t_product set deleted = 1 where id = ?")//逻辑删除
@Where(clause = "deleted = 0")
public class ProductEntity extends PojoEntity{

    private String pname;//商品名称
    private Double price;//价格
    private Double award;//奖励金额
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;//开始时间
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;//结束时间

    public ProductEntity(Long id) {
        this.setId(id);
    }

    public ProductEntity() {
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAward() {
        return award;
    }

    public void setAward(Double award) {
        this.award = award;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
