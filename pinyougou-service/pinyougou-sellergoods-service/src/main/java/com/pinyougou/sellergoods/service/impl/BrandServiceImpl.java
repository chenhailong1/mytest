package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        try{
            // DELETE FROM tb_brand WHERE ( id in ( ? , ? ) )
            // 创建示范对象
            Example example = new Example(Brand.class);
            // 创建删除条件
            Example.Criteria criteria = example.createCriteria();
            // 添加in条件 id in (?,?,?)
            criteria.andIn("id", Arrays.asList(ids));
            // 根据条件删除
            brandMapper.deleteByExample(example);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
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
    public PageResult findByPage(Brand brand, int page, int rows) {
        try{
            // 开启分页查询
            PageInfo<Brand> pageInfo = PageHelper.startPage(page, rows)
                    .doSelectPageInfo(new ISelect() {
                @Override
                public void doSelect() {
                    brandMapper.findAll(brand);
                }
            });
            return new PageResult(pageInfo.getTotal(), pageInfo.getList());
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Map<String, Object>> findallByIdAndName() {
        try{
            brandMapper.findAllByIdAndName();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
