package com.oumuv.order.controller;

import com.oumuv.order.commons.Page;
import com.oumuv.order.entitys.ProductEntity;
import com.oumuv.order.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

/***
 *<pre>
 *  商品controller
 *</pre>
 * @ClassName: ProductController
 * @Auther: oyf
 * @Date: 2019-03-06 09:59
 * @version : V1.0
 */
@Controller
@RequestMapping("product")
@Api(value = "product",description = "商品控制器")
public class ProductController extends AbstractController{

    @Autowired
    private ProductService productService;


    @ApiOperation(value ="查询所有商品",notes ="",httpMethod = "GET")
    @RequestMapping("prolist")
    public String prolist(ModelMap map) {
        Iterable<ProductEntity> all = productService.findAll();
        map.put("items", all);
        return "prolist";
    }

    @ApiOperation(value ="加载添加商品页面",notes ="",httpMethod = "GET")
    @RequestMapping("add")
    public String add() {
        return "pro_add";
    }

    @ApiOperation(value ="加载修改商品页面",notes ="",httpMethod = "GET")
    @RequestMapping(value = "updata/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public String updata(@PathVariable("id")String id,ModelMap map) {
        Optional<ProductEntity> byId = productService.findById(Long.parseLong(id));
        ProductEntity productEntity = byId.get();
        map.put("item", productEntity);
        return "pro_updata";
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    @ApiOperation(value ="删除商品")
    public Page del(@PathVariable("id") String id) {
        try {
            productService.deleteById(Long.parseLong(id));
            return new Page();
        }catch (Exception e){
            return new Page(e,"500",e.getMessage());
        }
    }

    @PutMapping("/save")
    @ResponseBody
    @ApiOperation(value ="保存商品")
    public Page save(ProductEntity entity ) {
        try {
            if (null == entity.getId()) {
                entity.setCreateAt(new Date());
            } else {
                entity.setUpdateAt(new Date());
            }
            ProductEntity save = productService.save(entity);
            return new Page(save);
        }catch (Exception e){
            e.printStackTrace();
            return new Page(e,"500","保存失败");
        }
    }

    @GetMapping("findall")
    @ResponseBody
    @ApiOperation(value = "查询所有有效的商品")
    public Page getList(@RequestParam(value = "pname",required = false)String pname) {
        Set<ProductEntity> allFN = productService.findAllFN(pname, new Date());
        return new Page(allFN);
    }


}
