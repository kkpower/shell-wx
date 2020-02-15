package com.bjpowernode.repository;

import com.bjpowernode.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductInfoRepository
 * @Description: TODO
 * @Author 876666981@qq.com
 * @Date 2020/1/5
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
