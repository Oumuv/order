package com.oumuv.order.entitys;

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
public class Person extends BaseEntity{

    private String uName;//名字
    private String fromArea;//地区

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
