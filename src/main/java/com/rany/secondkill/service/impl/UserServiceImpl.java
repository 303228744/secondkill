package com.rany.secondkill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rany.secondkill.mapper.UserMapper;
import com.rany.secondkill.pojo.User;
import com.rany.secondkill.service.IUserService;
import com.rany.secondkill.vo.LoginVo;
import com.rany.secondkill.vo.RespBean;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rany
 * @since 2023-03-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public RespBean doLogin(LoginVo loginVo) {

        return null;
    }
}
