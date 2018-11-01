package com.wangning.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("forward")
public class ForwardController {

    @RequestMapping("testForward")
    public String testForward(Model model) {
        model.addAttribute("aaa","我是一个兵3333");
        model.addAttribute("bbb","来自老百姓！");
        return "index";
    }

}
