package com.example.JettyProject.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginDao {
    @Insert("insert into user (username,password) values(#{username},#{password})")
    int UserRegister(String username,String password);

    @Select("select count(*) from user where username=#{username} and password=#{password}")
    int userIsExist(String username,String password);
}
