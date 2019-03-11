package com.oumuv.order.entitys;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/***
 *<pre>
 *  订单
 *</pre>
 * @ClassName: OrderEntity
 * @Auther: oyf
 * @Date: 2019-03-06 13:42
 * @version : V1.0
 */
@Entity
@Table(name = "t_order")
@SQLDelete(sql = "update t_order set deleted = 1 where id = ?")//逻辑删除
@Where(clause = "deleted = 0")
public class OrderEntity extends PojoEntity{

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "oid")
    private Set<OrderAndPro> products = new HashSet<OrderAndPro>();

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id")
    private Person person;

    private Double award;//奖励金额

    public Double getAward() {
        return award;
    }

    public void setAward(Double award) {
        this.award = award;
    }

    public Set<OrderAndPro> getProducts() {
        return products;
    }

    public void setProducts(Set<OrderAndPro> products) {
        this.products = products;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
