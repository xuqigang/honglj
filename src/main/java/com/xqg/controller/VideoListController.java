package com.xqg.controller;

import com.alibaba.fastjson.JSONObject;
import com.xqg.domain.User;
import com.xqg.domain.VideoEntity;
import com.xqg.service.UserService;
import com.xqg.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : YaweiZhang
 * @Description :
 * @Date : Created in 19:35 2018/4/19
 * @Modified by : YaweiZhang
 * @Param :
 */
@RestController
@RequestMapping(value = "/helloWorld")
public class VideoListController {


    @Autowired
    private VideoService videoService;


    @RequestMapping(value = "/getRecommendVideoList")
    public Map<String,Object> getRecommendVideoList(@RequestParam(value = "userId") Integer loginUserId){


//        String userId=request.getParameter("userId");


        List<VideoEntity> videoList = videoService.getRecommendVideoList(loginUserId);
        Map<String,Object> map = new HashMap<>();

        map.put("result",videoList);
        map.put("code","1");
        map.put("message","success");


        return map;

//
    }

    @RequestMapping(value = "/getHotVideoList")
    public Map<String,Object> getHotVideoList(@RequestParam(value = "userId") Integer loginUserId){


        List<VideoEntity> videoList = videoService.getHotVideoList(loginUserId);
        Map<String,Object> map = new HashMap<>();

        map.put("result",videoList);
        map.put("code","1");
        map.put("message","success");

        return map;

//
    }


    @RequestMapping(value = "/getMyVideoList")
    public Map<String,Object> getMyVideoList(@RequestParam(value = "userId") Integer userId){

        List<VideoEntity> videoList = videoService.getMyVideoList(userId,1);
        Map<String,Object> map = new HashMap<>();
        map.put("result",videoList);
        map.put("code","1");
        map.put("message","success");
        return map;
    }

    @RequestMapping(value = "/getFavoriteVideoList")
    public Map<String,Object> getFavoriteVideoList(@RequestParam(value = "userId") Integer userId){

        List<VideoEntity> videoList = videoService.getFavoriteVideoList(userId,1);
        Map<String,Object> map = new HashMap<>();
        map.put("result",videoList);
        map.put("code","1");
        map.put("message","success");
        return map;
    }
}
