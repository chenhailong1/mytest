package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 品牌服务接口实现类
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2018-11-16<p>
 */
@Service(interfaceName = "com.pinyougou.service.BrandService")
@Transactional
public class BrandServiceImpl implements BrandService {

    /** 注入数据访问接口代理对象 */
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public void save(Brand brand) {
        try{
            // 选择性添加(它会判断Brand实体中的属性是否有值，有值就生成到insert语句中)
            brandMapper.insertSelective(brand);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Brand brand) {
        try{
            // 选择性修改(它会判断Brand实体中的属性是否有值，有值就生成到update语句中)
            brandMapper.updateByPrimaryKeySelective(brand);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void deleteAll(Serializable[] ids) {

    }

    @Override
    public Brand findOne(Serializable id) {
        return null;
    }

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public List<Brand> findByPage(Brand brand, int page, int rows) {
        return null;
    }
}
