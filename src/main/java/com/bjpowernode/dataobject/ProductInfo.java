package com.bjpowernode.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName ProductInfo
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/5
 **/

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    /**描述*/
    private String productDescription;

    /**小图*/
    private String productIcon;

    /**状态 0正常 1下架*/
    private Integer productStatus;

    /**类目编号*/
    private Integer categoryType;
}
