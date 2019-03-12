package com.oumuv.order.controller;

import cn.hutool.core.util.ImageUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.oumuv.order.entitys.OrderEntity;
import com.oumuv.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/***
 *<pre>
 *
 *</pre>
 * @ClassName: OtherController
 * @Auther: oyf
 * @Date: 2019-03-12 15:38
 * @version : V1.0
 */
@Api
@Controller
@RequestMapping()
public class OtherController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "跳转其他页面")
    @RequestMapping("other")
    public String content(ModelMap map, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        return "other";
    }

    @ApiOperation(value = "红包登记列表")
    @RequestMapping("other/hb")
    public String arrangeHB(ModelMap map) {
        List<OrderEntity> byStatus = orderService.findByStatus(0);
        List<Object[]> result = new ArrayList<>();
        for (OrderEntity entity : byStatus) {
            Object[] o = new Object[4];
            o[0] = entity.getPerson().getId();
            o[1] = entity.getPerson().getFromArea();
            o[2] = entity.getPerson().getuName();
            o[3] = entity.getAward();
            result.add(o);
        }
        map.put("items", result);
        return "hb_list";
    }

    @ApiOperation(value = "查看红包对话框")
    @RequestMapping("other/hb/detail")
    public String detailHB(ModelMap map,String id) {
        getOrderEntity(map, id);
        return "hb_detail";
    }

    @RequestMapping()
    public OrderEntity getOrderEntity(ModelMap map, String id) {
        Optional<OrderEntity> byId = orderService.findById(Long.parseLong(id));
        OrderEntity entity = byId.get();
        map.put("item", entity);
        return entity;
    }

    /**
     * 生成二维码
     * @param response
     */
    @RequestMapping("other/QR")
    public void getQR(HttpServletResponse response,HttpSession session) {
        response.setHeader("Cache-Control", "private,no-cache,no-store");
        response.setContentType("image/png");
        ServletOutputStream outputStream = null;
        try {
             outputStream = response.getOutputStream();
            String localhost;
            if (session.getAttribute("localhost") == null || StringUtils.isEmpty((String) session.getAttribute("localhost"))) {
                InetAddress localHost = InetAddress.getLocalHost();
                localhost = localHost.getHostAddress();
                session.setAttribute("localhost", localhost);
            } else {
                localhost = (String) session.getAttribute("localhost");
            }
            QrCodeUtil.generate("http://" + localhost + ":8080/index", 300, 300, ImageUtil.IMAGE_TYPE_PNG, outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 红包发放页面二维码
     * @param response
     * @param session
     */
    @RequestMapping("other/hb/QR")
    public void getHBQR(HttpServletResponse response,HttpSession session) {
        response.setHeader("Cache-Control", "private,no-cache,no-store");
        response.setContentType("image/png");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            String localhost;
            if (session.getAttribute("localhost") == null || StringUtils.isEmpty((String) session.getAttribute("localhost"))) {
                InetAddress localHost = InetAddress.getLocalHost();
                localhost = localHost.getHostAddress();
                session.setAttribute("localhost", localhost);
            } else {
                localhost = (String) session.getAttribute("localhost");
            }
            QrCodeUtil.generate("http://" + localhost + ":8080/other/hb", 300, 300, ImageUtil.IMAGE_TYPE_PNG, outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
