package com.lrm.controller.user;

import com.lrm.po.User;
import com.lrm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("register")
    public String registerPage() {
        return "user/register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String nickname,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = registerService.saveUser(username, password, nickname);
        //System.out.println("user= "+user);测试user是否注册出来
        if (user != null) {//注册成功。直接帮忙登录
            session.setAttribute("user",user);
            return "redirect:/";
        } else {
            attributes.addFlashAttribute("message", "注册失败");
            return "user/register";
        }
    }

}
