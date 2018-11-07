package com.wangning.example.demo.entity.request;

import javax.validation.constraints.NotBlank;

public class HelloWorldReq {
    @NotBlank(message = "{fuck.notBlank}")
    private String req1;
    @NotBlank(message = "骚年，这个参数不能为空")
    private String req2;

    public String getReq2() {
        return req2;
    }

    public void setReq2(String req2) {
        this.req2 = req2;
    }

    public String getReq1() {
        return req1;
    }

    public void setReq1(String req1) {
        this.req1 = req1;
    }
}
