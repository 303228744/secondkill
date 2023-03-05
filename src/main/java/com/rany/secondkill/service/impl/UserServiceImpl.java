package com.rany.secondkill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rany.secondkill.mapper.UserMapper;
import com.rany.secondkill.pojo.User;
import com.rany.secondkill.service.IUserService;
import com.rany.secondkill.uitls.MD5Util;
import com.rany.secondkill.uitls.validatorUtil;
import com.rany.secondkill.vo.LoginVo;
import com.rany.secondkill.vo.RespBean;
import com.rany.secondkill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

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

    @Autowired
    private UserMapper userMapper;

    @Override
    public RespBean doLogin(LoginVo loginVo) {

        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        // 参数校验
        // 校验手机号与密码是否为空
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        // 校验手机号格式
        if (validatorUtil.isMobile(mobile)) {
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }

        // 根据手机号选取用户
        User user = userMapper.selectById(mobile);
        if (user == null) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        // 校验密码是否正确
        if (!MD5Util.formPassToDBPass(password, user.getSalt()).equals(user.getPassword())) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        return RespBean.success();
    }
}
