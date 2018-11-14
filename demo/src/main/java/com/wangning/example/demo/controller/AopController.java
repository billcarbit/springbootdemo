package com.wangning.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangning.example.demo.entity.request.HelloWorldReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aop")
public class AopController {


    @Autowired
    WebLogAspect mWebLogAspect;

    @RequestMapping("string")
    public String aop(String arg) {
        mWebLogAspect.weblog();
        return arg;
    }


    @RequestMapping("jsonParam")
    public JSONObject getRequestParam(@RequestBody HelloWorldReq requestParam) {
        JSONObject json = (JSONObject) JSON.toJSON(requestParam);
        return json;
    }


}
