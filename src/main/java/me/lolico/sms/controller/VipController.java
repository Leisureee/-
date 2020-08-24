package me.lolico.sms.controller;

import me.lolico.sms.entity.Vip;
import me.lolico.sms.service.VipService;
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
public class VipController {
    final VipService vipService;

    public VipController(VipService vipService) {
        this.vipService = vipService;
    }

    @GetMapping(value = "/VipController", params = "action=show")
    public String common(Model model) throws SQLException {
        List<Vip> vipList = vipService.getAllVip();
        model.addAttribute("vipList", vipList);
        return "welcome";
    }

    @PostMapping("/VipController")
    public String common(RedirectAttributes redirectAttributes, String action, Vip vip) throws SQLException {
        switch (action) {
            case "delete": {
                vipService.deleteVipById(vip.getId());
                break;
            }
            case "update": {
                vipService.updateVip(vip);
                break;
            }
            case "insert": {
                vipService.insertVip(vip);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        List<Vip> vipList = vipService.getAllVip();
        redirectAttributes.addFlashAttribute("vipList", vipList);
        return "redirect:/index";
    }
}
