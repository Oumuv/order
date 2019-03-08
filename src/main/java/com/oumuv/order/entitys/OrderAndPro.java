package com.oumuv.order.entitys;

import javax.persistence.*;

/***
 *<pre>
 *  订单-商品中介表
 *</pre>
 * @ClassName: OrderAndPro
 * @Auther: oyf
 * @Date: 2019-03-06 14:18
 * @version : V1.0
 */
@Entity
@Table(name = "order_product")
public class OrderAndPro extends BaseEntity{

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "oid")
    private OrderEntity oid;

    @OneToOne
    @JoinColumn
    private ProductEntity pid;
    private int quantity;//数量

    public ProductEntity getPid() {
        return pid;
    }

    public void setPid(ProductEntity pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOid() {
        return oid;
    }

    public void setOid(OrderEntity oid) {
        this.oid = oid;
    }
}
