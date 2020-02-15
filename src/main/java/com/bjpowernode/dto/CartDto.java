package com.bjpowernode.dto;

import lombok.Data;

/**
 * @ClassName CartDto
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/8
 **/
@Data
public class CartDto {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 数量
     */
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
