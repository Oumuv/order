package com.oumuv.order.entitys;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

/***
 *<pre>
 *  人员
 *</pre>
 * @ClassName: Person
 * @Auther: oyf
 * @Date: 2019-03-06 13:49
 * @version : V1.0
 */
@Entity
@Table(name = "t_person")
@SQLDelete(sql = "update t_order set deleted = 1 where id = ?")//逻辑删除
@Where(clause = "deleted = 0")
public class Person extends BaseEntity{

    private String uName;//名字
    private String fromArea;//地区

    public Person() {
    }

    public Person(String uName, String fromArea) {
        this.uName = uName;
        this.fromArea = fromArea;
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
}
