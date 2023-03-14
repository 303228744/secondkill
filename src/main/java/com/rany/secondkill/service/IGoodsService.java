package com.rany.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rany.secondkill.pojo.Goods;
import com.rany.secondkill.pojo.User;
import com.rany.secondkill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rany
 * @since 2023-03-06
 */
public interface IGoodsService extends IService<Goods> {

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);

}
