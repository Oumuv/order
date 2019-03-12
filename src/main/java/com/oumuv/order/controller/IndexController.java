package com.oumuv.order.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.oumuv.order.service.OrderService;
import com.oumuv.order.service.PersonService;
import com.oumuv.order.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String content(ModelMap map, HttpSession session, HttpServletRequest request) {
        String contextPath = session.getServletContext().getRealPath("/");
        String contextPath2 = session.getServletContext().getContextPath();
        String contextPath1 = request.getServletContext().getContextPath();
        map.put("option1_data", orderService.get30DatesDateByUname());
        map.put("option2_data", orderService.getCollect());
        map.put("option3_data", orderService.get30DatesData());
//        try {
//            InetAddress localHost = InetAddress.getLocalHost();
//            String s = localHost.toString();
            // 生成指定url对应的二维码到文件，宽和高都是300像素
//            QrCodeUtil.generate(s+"/index/", 300, 300);
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
        return "index_content";
    }


}
