package me.lolico.sms.controller;

import me.lolico.sms.entity.Goods;
import me.lolico.sms.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;

/**
 * @author lolico
 */
@Controller
public class GoodsController {

    final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping(value = "/GoodsController", params = "action=show")
    public String common(Model model) throws SQLException {
        List<Goods> goodsList = goodsService.getAllGoods();
        model.addAttribute("goodsList", goodsList);
        return "welcome";
    }

    @PostMapping("/GoodsController")
    public String common(RedirectAttributes redirectAttributes, String action, Goods goods) throws SQLException {
        switch (action) {
            case "delete": {
                goodsService.deleteGoodsById(goods.getId());
                break;
            }
            case "update": {
                goodsService.updateGoods(goods);
                break;
            }
            case "insert": {
                goodsService.insertGoods(goods);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        List<Goods> goodsList = goodsService.getAllGoods();
        redirectAttributes.addFlashAttribute("goodsList", goodsList);
        return "redirect:/index";
    }
}
