package com.oumuv.order.entitys;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/***
 *<pre>
 *
 *</pre>
 * @ClassName: BaseEntity
 * @Auther: oyf
 * @Date: 2019-03-02 23:48
 * @version : V1.0
 */

@MappedSuperclass
public class BaseEntity implements Serializable {


    private static final long serialVersionUID = -6103803459011100124L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
