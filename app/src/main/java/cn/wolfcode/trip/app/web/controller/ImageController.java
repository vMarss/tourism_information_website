package cn.wolfcode.trip.app.web.controller;

import cn.wolfcode.trip.app.util.UploadUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ImageController {

    //文件上传返回值的设计
    //成功与否  图片存储的位置
    @PostMapping("/images")
    public Map<String, Object> upload(MultipartFile file) {

        //调用存文件的工具类存文件，获取Url作为返回值
        String uploadPath = UploadUtil.upload(file, UploadUtil.commonPath + "/upload");

        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        map.put("url", uploadPath);
        return map;
    }
}
