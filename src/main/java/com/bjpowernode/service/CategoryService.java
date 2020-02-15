package com.bjpowernode.service;

import com.bjpowernode.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @ClassName CategoryService
 * @Description: TODO
 * @Author 876666981@qq.com
 * @Date 2020/1/5
 **/
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
