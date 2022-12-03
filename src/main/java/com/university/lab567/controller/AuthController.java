package com.university.lab567.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/PersonalCabinet")
    public String getSuccessPage(){
        return "PersonalCabinet";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "registration";
    }
}
