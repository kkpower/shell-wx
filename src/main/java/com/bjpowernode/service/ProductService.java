package com.bjpowernode.service;

import com.bjpowernode.dataobject.ProductInfo;
import com.bjpowernode.dto.CartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description: TODO
 * @Author 876666981@qq.com
 * @Date 2020/1/5
 **/
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架的商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDto> cartDtoList);

    //减库存
    void decreaseStock(List<CartDto> cartDtoList);
}
