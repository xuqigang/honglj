package com.xqg.controller;

import com.xqg.domain.UserInfoEntity;
import com.xqg.service.UserInfoService;
import com.xqg.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/alterUserInfo")
    public Map<String,Object> alterUserInfo(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "nickName") String nickName, @RequestParam(value = "sex" ,required =false) Integer sex, @RequestParam(value = "motto" ,required =false) String motto, @RequestParam(value = "headportrait" ,required =false) String headportrait, @RequestParam(value = "age" ,required =false) String  age){


        UserInfoEntity userInfo = new UserInfoEntity();
        userInfo.setUserId(userId);

        if (nickName != null){
            userInfo.setNickName(nickName);
        }
        if (age != null){
            userInfo.setAge(age);
        }
        if (motto != null) {
            userInfo.setMotto(motto);
        }

        if (sex != null){
            userInfo.setSex(sex);
        }

        if (headportrait != null){
            userInfo.setHeadportrait(headportrait);
        }


        int total = userInfoService.updateUserInfo(userInfo);

        if (total > 0){
            return ResponseUtils.result("0","信息修改成功",null);
        } else  {
            return ResponseUtils.result("0","该用户不存在",null);
        }

    }

}
