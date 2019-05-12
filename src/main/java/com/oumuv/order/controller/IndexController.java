package com.oumuv.order.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.oumuv.order.service.OrderService;
import com.oumuv.order.service.PersonService;
import com.oumuv.order.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/***
 *<pre>
 *
 *</pre>
 * @ClassName: IndexController
 * @Auther: oyf
 * @Date: 2019-03-11 16:55
 * @version : V1.0
 */
@Api(value = "主页相关的controller")
@Controller
@RequestMapping()
public class IndexController {

    @Autowired
    ProductService productService;
    @Autowired
    PersonService personService;
    @Autowired
    OrderService orderService;


    @RequestMapping("content")
    public String content(ModelMap map) {
        map.put("option1_data", orderService.get30DatesDateByUname());
        map.put("option2_data", orderService.getCollect());
        map.put("option3_data", orderService.get30DatesData());
        return "index_content";
    }

    @RequestMapping("getdate1")
    @ResponseBody
    public List<Object[]> getDate1(String start, String end) {
        return orderService.getCollect(start,end);
    }

    @RequestMapping("getdate2")
    @ResponseBody
    public List<Object[]> getDate2(String start, String end) {
        List<Object[]> collect = orderService.getCollect(start, end);
        return collect;
    }






}
