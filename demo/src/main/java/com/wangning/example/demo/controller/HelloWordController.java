package com.wangning.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangning.example.demo.entity.request.HelloWorldReq;
import com.wangning.example.demo.entity.response.HelloWorldResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("hello")
public class HelloWordController {

    @RequestMapping("string")
    public String getString() {
        return "FAFADFFGASGS";
    }

    @RequestMapping("forward")
    public String testForward() {
        return "forward:/index";
    }


    /**
     * 会过滤空值
     *
     * @return
     */
    @RequestMapping("jsonString")
    public String getJsonString() {
        HelloWorldResp resp = new HelloWorldResp();
        JSONObject json = (JSONObject) JSON.toJSON(resp);
        return json.toJSONString();
    }

    /**
     * 不会过滤空值
     *
     * @return
     */
    @RequestMapping("jsonObject")
    public JSONObject getJsonObject() {
        HelloWorldResp resp = new HelloWorldResp();
        JSONObject json = (JSONObject) JSON.toJSON(resp);
        return json;
    }

    /**
     * 用实体类接收入参
     *
     * @param requestParam
     * @return
     */
    @RequestMapping("jsonParam")
    public JSONObject getRequestParam(@RequestBody HelloWorldReq requestParam) {
        JSONObject json = (JSONObject) JSON.toJSON(requestParam);
        return json;
    }

    /**
     * 响应一个实体类
     *
     * @return
     */
    @RequestMapping("responseBean")
    public HelloWorldResp responseBean() {
        HelloWorldResp resp = new HelloWorldResp();
        resp.setAaa("f1f1f3");
        return resp;
    }


}
