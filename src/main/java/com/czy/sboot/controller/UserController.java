package com.czy.sboot.controller;

import com.czy.sboot.entity.Users;
import com.czy.sboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index.jsp")
    public String login(Model model){
        Users users = userService.findUser();
        model.addAttribute("user",users);
       return "index";
    }

}
