package com.oumuv.order.entitys;

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
public class OrderEntity extends PojoEntity{

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "oid")
    private Set<OrderAndPro> products = new HashSet<OrderAndPro>();

    @OneToOne
    @JoinColumn
    private Person person;

    private Double award;//奖励金额

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
