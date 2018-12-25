package com.todo.checklist.controller;

import com.todo.checklist.model.dto.UserRegisterRequest;
import com.todo.checklist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model, @RequestParam(name = "error", required = false)String error){
        if(error!= null){
            model.addAttribute("message",error);
        }
        return "register";
    }

    @PostMapping("/register")
    public String submitRegisterForm(UserRegisterRequest userRegisterRequest){
        boolean success = userService.tryRegister(userRegisterRequest);
        if(success){
            return "redirect:/login";
        }
        return "redirect:/register?error=Registration error";
    }
}
