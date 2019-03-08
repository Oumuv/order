package com.oumuv.order.entitys;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/***
 *<pre>
 *
 *</pre>
 * @ClassName: PojoEntity
 * @Auther: oyf
 * @Date: 2019-03-06 14:05
 * @version : V1.0
 */
@MappedSuperclass
public class PojoEntity extends BaseEntity {


    private Long createdBy;

    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Temporal(TemporalType.DATE)
    private Date updateAt;

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
