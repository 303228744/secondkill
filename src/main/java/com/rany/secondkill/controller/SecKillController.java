package com.rany.secondkill.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rany.secondkill.pojo.Order;
import com.rany.secondkill.pojo.SeckillOrder;
import com.rany.secondkill.pojo.User;
import com.rany.secondkill.service.IGoodsService;
import com.rany.secondkill.service.IOrderService;
import com.rany.secondkill.service.ISeckillOrderService;
import com.rany.secondkill.vo.GoodsVo;
import com.rany.secondkill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secKill")
public class SecKillController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ISeckillOrderService seckillOrderService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/doSecKill")
    public String doSecKill(Model model, User user, Long goodsId) {
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        if (goods.getStockCount() < 1) {
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";
        }
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        if (seckillOrder != null) {
            model.addAttribute("errmsg", RespBeanEnum.REPEATE_ERROR.getMessage());
        }

        Order order = orderService.secKill(user, goods);
        model.addAttribute("order", order);
        model.addAttribute("goods", goods);

        return "orderDetail";
    }


}
