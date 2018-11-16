package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌控制器
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2018-11-16<p>
 */
@RestController
public class BrandController {

    /**
     * 配置引用服务，产生服务接口代理对象
     * timeout: 调用服务层方法超时时间
     * */
    @Reference(timeout = 5000)
    private BrandService brandService;

    /** 查询全部品牌 */
    @GetMapping("/brand/findAll")
    public List<Brand> findAll(){
        System.out.println("brandService: " + brandService);
        return brandService.findAll();
    }
}
