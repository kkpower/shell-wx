package com.bjpowernode.repository;

import com.bjpowernode.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductCategoryRepository
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/5
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
