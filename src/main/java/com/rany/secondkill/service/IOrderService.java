package com.rany.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rany.secondkill.pojo.Order;
import com.rany.secondkill.pojo.User;
import com.rany.secondkill.vo.GoodsVo;
import com.rany.secondkill.vo.OrderDetailVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rany
 * @since 2023-03-06
 */
public interface IOrderService extends IService<Order> {

    Order secKill(User user, GoodsVo goods);

    OrderDetailVo detail(Long orderId);
}
