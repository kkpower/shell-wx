package com.bjpowernode.converter;

import com.bjpowernode.dataobject.OrderMaster;
import com.bjpowernode.dto.OrderDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrderMaster2OrderDtoConverter
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/9
 **/
public class OrderMaster2OrderDtoConverter {

    public static OrderDto convert(OrderMaster orderMaster){
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster,orderDto);
        return orderDto;
    }

    public static List<OrderDto> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->
                    convert(e)
                ).collect(Collectors.toList());
    }

}
