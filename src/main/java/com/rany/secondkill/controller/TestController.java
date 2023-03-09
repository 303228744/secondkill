package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/ping")
    public String hello(Model model) {
        model.addAttribute("msg", "连接成功");
        return "ping";
    }

}
