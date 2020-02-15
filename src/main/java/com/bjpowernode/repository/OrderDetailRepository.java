package com.bjpowernode.repository;

import com.bjpowernode.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName OrderDetailRepository
 * @Description: TODO
 * @Author 876666981@qq.com
 * @Date 2020/1/8
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
