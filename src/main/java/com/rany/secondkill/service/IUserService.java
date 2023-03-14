package com.rany.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rany.secondkill.pojo.User;
import com.rany.secondkill.vo.LoginVo;
import com.rany.secondkill.vo.RespBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rany
 * @since 2023-03-02
 */

public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    // 根据 cookie 获取用户
    User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);
}
