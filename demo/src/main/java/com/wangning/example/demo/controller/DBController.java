package com.wangning.example.demo.controller;

import com.wangning.example.demo.dao.UserInfoDao;
import com.wangning.example.demo.dao.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class DBController {

    @Autowired
    private UserInfoDao userInfoDao;

    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType() {
        return  userInfoDao.getDbType();
    }

    @RequestMapping("/getDbTypeUserObject")
    public List<UserInfo> getDbTypeUserObject() {
        return  userInfoDao.getDbTypeUserObject();
    }


}
