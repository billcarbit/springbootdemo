package com.wangning.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangning.example.demo.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class UploadController {

    /**
     * @param file 要上传的文件
     * @return
     */
    @RequestMapping("fileUpload")
    public String upload(@RequestParam("fileName222") MultipartFile file, Map<String, Object> map) {
        // 要上传的目标文件存放路径
        String localPath = "D:/Photos";
        // 上传成功或者失败的提示
        String msg = "";
        if (FileUtils.upload(file, localPath, file.getOriginalFilename())) {
            // 上传成功，给出页面提示
            msg = "上传成功！";
        } else {
            msg = "上传失败！";

        }
        // 显示图片
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
        return "index";
    }
}
