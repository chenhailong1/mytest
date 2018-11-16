package com.pinyougou.service;

import com.pinyougou.pojo.Brand;

import java.util.List;

/**
 * 品牌服务接口类
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2018-11-16<p>
 */
public interface BrandService {

    /** 查询全部品牌 */
    List<Brand> findAll();
}
