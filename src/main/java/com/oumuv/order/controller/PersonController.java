package com.oumuv.order.controller;

import com.oumuv.order.commons.Page;
import com.oumuv.order.entitys.Person;
import com.oumuv.order.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/***
 *<pre>
 *  人员控制器
 *</pre>
 * @ClassName: PersonController
 * @Auther: oyf
 * @Date: 2019-03-08 11:25
 * @version : V1.0
 */
@Api
@Controller
@RequestMapping("person")
public class PersonController extends AbstractController {
    @Autowired
    PersonService service;

    @GetMapping("find")
    @ResponseBody
    public Page find(@RequestParam(value = "uname",required = false) String name, @RequestParam(value = "fromArea",required = false)String fromArea) {
        Set<Person> people = service.find(name, fromArea);
        return new Page(people);
    }

    @GetMapping("findarea")
    @ResponseBody
    public Page findALlArea(@RequestParam(value = "fromArea",required = false) String fromArea) {
        Set<String> allArea = service.findAllArea(fromArea);
        return new Page(allArea);
    }

    @PutMapping("add")
    @ResponseBody
    public Page add(@RequestParam(value = "uname",required = true)String name, @RequestParam(value = "fromArea",required = true)String fromArea) {
        Person entity = new Person();
        entity.setuName(name);
        entity.setFromArea(fromArea);
        service.save(entity);
        return new Page();
    }
}
