package com.example.JettyProject.controller;

import com.example.JettyProject.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("user")
public class LoginController {

        @Autowired
        private LoginService loginService;

        @RequestMapping("/userRegister")
        @ResponseBody
        public String UserLogin(String username,String password){

            if(username == null || password == null){
                return "username or password must be an invalid value";
            }
            else {
                int count = loginService.userIsExist(username,password);
                if (count == 0) {
                    loginService.UserRegister(username, password);
                    return "Register success";
                } else {
                    return "Resister failed , user " + username + " is already register";
                }
            }
        }
      

}
