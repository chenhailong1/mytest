package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.TypeTemplate;
import com.pinyougou.service.TypeTemplateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Reference(timeout = 10000)
    private TypeTemplateService typeTemplateService;

    //分页查询类型模板
    @GetMapping("/findByPage")
    public PageResult findByPage(TypeTemplate typeTemplate,Integer page,Integer rows){
        if (typeTemplate !=null && StringUtils.isNoneBlank(typeTemplate.getName())){
            try{
                typeTemplate.setName(new String(typeTemplate.getName()));
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        return typeTemplateService.findByPage(typeTemplate,page,rows);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody TypeTemplate typeTemplate){
        try{
            typeTemplateService.save(typeTemplate);
            return  true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/update")
    public boolean update(@RequestBody TypeTemplate typeTemplate){
        try {
            typeTemplateService.update(typeTemplate);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
