package com.oumuv.order.service;

import com.oumuv.order.entitys.OrderEntity;
import com.oumuv.order.entitys.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/***
 *<pre>
 *
 *</pre>
 * @interface: ProductService
 * @auther: oyf
 * @date: 2019-03-05 16:56
 * @version : V1.0
 */
public interface PersonService extends CrudRepository<Person,Long> {

    @Query(value = "from Person where uName like CONCAT('%',:uname,'%') and fromArea like CONCAT('%',:fromArea,'%')")
    Set<Person> find(@Param("uname") String name, @Param("fromArea")String fromArea);

    @Query(value = "select from_area from t_person where from_area LIKE CONCAT('%',:fromArea,'%') GROUP BY from_area",nativeQuery = true)
    Set<String> findAllArea(@Param("fromArea")String fromArea);

}
