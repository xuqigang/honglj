package com.xqg.controller;

import com.xqg.domain.UserDetailsEntity;
import com.xqg.service.UserService;
import com.xqg.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserLoginController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public Map<String,Object> login(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password){


        Map<String,Object> checkResult = this.checkLoginParam(userName,password);
        if (checkResult != null){
            return checkResult;
        } else {

            UserDetailsEntity loginInfo = new UserDetailsEntity();
            loginInfo.setUserName(userName);
            loginInfo.setPassword(password);
            UserDetailsEntity userInfo = userService.getUserInfoByEntity(loginInfo);

            if (userInfo != null){
                return ResponseUtils.result("1","success--",userInfo);
            } else {
                return ResponseUtils.result("0","用户名或密码不正确",null);
            }

        }

    }

    @RequestMapping(value = "/register")
    public Map<String,Object> register(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password,@RequestParam(value = "verificationCode") String verificationCode){


        UserDetailsEntity registerInfo = new UserDetailsEntity();
        registerInfo.setUserName(userName);

        UserDetailsEntity userInfo = userService.getUserInfoByEntity(registerInfo);

        if (userInfo != null){
            return ResponseUtils.result("0","该用户已存在，请更换手机号",userName);
        } else {


            registerInfo.setPassword(password);
            registerInfo.setPhone(userName);
            int total = userService.insertUser(registerInfo);
            if (total > 0) {
                UserDetailsEntity loginInfo = userService.getUserInfoByEntity(registerInfo);
                return ResponseUtils.result("1","注册成功",loginInfo);
            } else  {
                return ResponseUtils.result("0","注册失败，请稍等重试",userName);
            }
        }


    }

    @RequestMapping(value = "/alterPassword")
    public Map<String,Object> alterPassword(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "newPassword") String password,@RequestParam(value = "verificationCode") String verificationCode){


        UserDetailsEntity loginInfo = new UserDetailsEntity();
        loginInfo.setUserId(userId);

        UserDetailsEntity userInfo = userService.getUserInfoByEntity(loginInfo);

        if (userInfo != null){
            userInfo.setPassword(password);
            userService.updateByUserDetailsEntity(userInfo);
            return ResponseUtils.result("0","修改成功",userInfo);

        } else {
            return ResponseUtils.result("0","该用户不存在",null);
        }

    }

    @RequestMapping(value = "/getVerificationCode")
    public Map<String,Object> getVerificationCode(@RequestParam(value = "phone") Integer phone){


        int verificationCode = (int)((Math.random()*9+1)*100000);
        return ResponseUtils.result("0","验证码发送成功",verificationCode);

    }

    @RequestMapping(value = "/alterUserInfo")
    public Map<String,Object> alterUserInfo(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "nickName") String nickName,@RequestParam(value = "sex" ,required =false) Integer sex,@RequestParam(value = "motto" ,required =false) String motto,@RequestParam(value = "headportrait" ,required =false) String headportrait,@RequestParam(value = "age" ,required =false) Integer age){


        UserDetailsEntity userInfo = new UserDetailsEntity();
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


        int total = userService.updateByUserDetailsEntity(userInfo);

        if (total > 0){
            return ResponseUtils.result("0","信息修改成功",null);
        } else  {
            return ResponseUtils.result("0","该用户不存在",null);
        }

    }


    private Map<String,Object> checkLoginParam(String userName,String password){


        if (userName == "" || userName == null){
            return ResponseUtils.result("0","请输入用户名",null);
        }

        if (password == null || password == "") {
            return ResponseUtils.result("0", "请输入密码", null);
        }

        return null;

    }

}
