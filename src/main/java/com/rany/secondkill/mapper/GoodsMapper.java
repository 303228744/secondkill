package com.rany.secondkill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rany.secondkill.vo.GoodsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rany
 * @since 2023-03-06
 */

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> findGoodsVo();
}
