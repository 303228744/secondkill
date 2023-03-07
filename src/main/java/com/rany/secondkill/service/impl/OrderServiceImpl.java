package com.rany.secondkill.service.impl;

import com.rany.secondkill.pojo.Order;
import com.rany.secondkill.mapper.OrderMapper;
import com.rany.secondkill.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rany
 * @since 2023-03-06
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
