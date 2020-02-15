package com.bjpowernode.repository;

import com.bjpowernode.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderMasterRepository
 * @Description: TODO
 * @Author 876666981@qq.com
 * @Date 2020/1/8
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
