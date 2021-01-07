package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuqd
 * @date 2021/1/6 下午 11:03:14
 */
@Controller
public class index {

    @RequestMapping({"/","/login"})
    public String login(Model model){
        model.addAttribute("msg","Hello shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String name,String password){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();

        return null;
    }

}
