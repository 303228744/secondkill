package controller;

import com.rany.secondkill.pojo.User;
import com.rany.secondkill.service.IGoodsService;
//import com.rany.secondkill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {

//    @Autowired
//    private IUserService userService;

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/toList")
    public String toList(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }

    // 跳转商品详情页
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId) {
        model.addAttribute("user", user);
        model.addAttribute("goodsVo", goodsService.findGoodsVoByGoodsId(goodsId));
        return "goodsDetail";
    }
}
