package com.wangning.example.demo.controller;

import com.wangning.example.demo.entity.request.HelloReq;
import com.wangning.example.demo.entity.request.MsgReq;
import com.wangning.example.demo.entity.response.HelloResp;
import com.wangning.example.demo.entity.response.LoginResp;
import com.wangning.example.demo.entity.response.MsgItemResp;
import com.wangning.example.demo.entity.response.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("msg")
public class MsgController extends BaseController {


    @RequestMapping("getMsgList")
    public Result<List<MsgItemResp>> getMsgList(@RequestBody MsgReq requestParam) {
        System.out.println("getMsgList");

        int pageIndex = requestParam.getPageIndex();
        int pageSize = requestParam.getPageSize();
        List<MsgItemResp> list = new ArrayList<>();

        if (pageIndex == 0) {
            MsgItemResp item;
            for (int i = 0; i < pageSize; i++) {
                item = new MsgItemResp();
                item.setName("A" + i);
                item.setCreator("B" + i);
                item.setDate("C" + i);
                list.add(item);
            }
        }

        if (pageIndex == 1) {
            MsgItemResp item;
            for (int i = 0; i < 3; i++) {
                item = new MsgItemResp();
                item.setName("A" + i);
                item.setCreator("B" + i);
                item.setDate("C" + i);
                list.add(item);
            }
        }

        Result result = new Result<List<MsgItemResp>>();
        result.setData(list);
        return result;
    }


}
