package com.lrm.controller;

import com.lrm.dao.UserRepository;
import com.lrm.po.User;
import com.lrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AboutShowController {
    @Autowired
    private UserService userService;
    /*@GetMapping("/about")
    public String about() {
        return "about";
    }*/
    @GetMapping("/about/{id}")
    public String about(@PathVariable Long id, Model model) {
        model.addAttribute("owner", userService.getUser(id));
        return "about";
    }
}
