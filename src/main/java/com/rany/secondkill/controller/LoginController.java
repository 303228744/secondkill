package com.rany.secondkill.controller;

import com.rany.secondkill.service.IUserService;
import com.rany.secondkill.vo.LoginVo;
import com.rany.secondkill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/toLogin")
    public String tologin() {
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean dologin(LoginVo loginVo) {
        return userService.doLogin(loginVo);
    }

}
