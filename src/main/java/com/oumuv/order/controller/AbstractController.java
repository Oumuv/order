package com.oumuv.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/***
 *<pre>
 *
 *</pre>
 * @ClassName: AbstractController
 * @Auther: oyf
 * @Date: 2019-03-05 22:00
 * @version : V1.0
 */
@Controller
public class AbstractController {

    @GetMapping("index")
    public String index(ModelMap model) {
        return "index";
    }
}
