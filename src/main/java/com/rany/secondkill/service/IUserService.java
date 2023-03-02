package com.rany.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rany.secondkill.pojo.User;
import com.rany.secondkill.vo.LoginVo;
import com.rany.secondkill.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rany
 * @since 2023-03-02
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVo loginVo);
}
