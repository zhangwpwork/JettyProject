package com.example.JettyProject.service;


public interface LoginService {

    int UserRegister(String username,String password);

    int userIsExist(String username,String password);
}
