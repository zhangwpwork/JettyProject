package com.example.JettyProject.service.Impl;

import com.example.JettyProject.dao.LoginDao;
import com.example.JettyProject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;

    @Override
    public int UserRegister(String username, String password) {
        return loginDao.UserRegister(username,password);
    }

    @Override
    public int userIsExist(String username, String password) {
        return loginDao.userIsExist(username, password);
    }
}
