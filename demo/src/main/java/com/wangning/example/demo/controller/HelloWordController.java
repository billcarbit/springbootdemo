package com.wangning.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangning.example.demo.entity.request.HelloReq;
import com.wangning.example.demo.entity.request.HelloWorldReq;
import com.wangning.example.demo.entity.request.LoginReq;
import com.wangning.example.demo.entity.response.HelloResp;
import com.wangning.example.demo.entity.response.HelloWorldResp;
import com.wangning.example.demo.entity.response.LoginResp;
import com.wangning.example.demo.entity.response.Result;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("hello")
public class HelloWordController extends BaseController {

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


    @RequestMapping("login")
    public Result<LoginResp> login(@RequestBody(required = true) LoginReq requestParam) {
        System.out.println("login");
        LoginResp resp = new LoginResp();
        resp.setUsername("张三");
        Result result = new Result<LoginResp>();
        result.setData(resp);
        return result;
    }

    @RequestMapping("firstHello")
    public Result<HelloResp> firstHello(@RequestBody HelloReq requestParam) {
        System.out.println("firstHello");
        HelloResp resp = new HelloResp();
        resp.setGood("服务端响应成功");
        Result result = new Result<LoginResp>();
        result.setData(resp);
        return result;
    }


    @RequestMapping(value = "formUrlEncoded", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public Result<LoginResp> formUrlEncoded(String account, String pwd) {

        System.out.println("account=" + account + ",pwd=" + pwd);

        LoginResp resp = new LoginResp();
        resp.setUsername(account);
        Result result = new Result<LoginResp>();
        result.setData(resp);
        return result;
    }

    /**
     * 入参校验
     *
     * @param requestParam
     * @return
     */
    @RequestMapping("validatedParam")
    public HelloWorldResp validatedParam(@RequestBody @Validated HelloWorldReq requestParam) {
        HelloWorldResp resp = new HelloWorldResp();
        resp.setAaa(requestParam.getReq1());
        return resp;
    }
}
