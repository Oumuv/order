package com.oumuv.order.service;

import com.oumuv.order.entitys.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/***
 *<pre>
 *
 *</pre>
 * @interface: ProductService
 * @auther: oyf
 * @date: 2019-03-05 16:56
 * @version : V1.0
 */
public interface ProductService extends CrudRepository<ProductEntity,Long> {


}
