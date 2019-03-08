package com.oumuv.order.service.impl;

import com.oumuv.order.entitys.ProductEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/***
 *<pre>
 *  这个类暂时没有实现方法
 *</pre>
 * @ClassName: AbstractServiceImpl
 * @Auther: oyf
 * @Date: 2019-03-06 16:36
 * @version : V1.0
 */
public abstract class AbstractServiceImpl extends HibernateDaoSupport {


}
