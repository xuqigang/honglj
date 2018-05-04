package com.xqg.controller;

import com.xqg.domain.UserEntity;
import com.xqg.domain.UserInfoEntity;
import com.xqg.service.UserInfoService;
import com.xqg.service.UserService;
import com.xqg.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserService userService;


    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "/login")
    public Map<String,Object> login(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password){


        Map<String,Object> checkResult = this.checkLoginParam(userName,password);
        if (checkResult != null){
            return checkResult;
        } else {

            UserEntity loginInfo = new UserEntity();
            loginInfo.setUserName(userName);
            loginInfo.setPassword(password);
            List<UserEntity> loginInfoList = userService.getUser(loginInfo);

            if (loginInfoList.size() > 0){

                loginInfo = loginInfoList.get(0);
                UserInfoEntity userInfo = new UserInfoEntity();
                userInfo.setUserId(loginInfo.getUserId());

                List<UserInfoEntity> userInfos = userInfoService.getUserInfo(userInfo);
                return ResponseUtils.result("1","success--",userInfos);
            } else {
                return ResponseUtils.result("0","用户名或密码不正确",null);
            }

        }

    }

    @RequestMapping(value = "/register")
    public Map<String,Object> register(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password,@RequestParam(value = "verificationCode") String verificationCode){


        UserEntity registerUser = new UserEntity();
        registerUser.setUserName(userName);
        registerUser.setLoginType(3);

        List<UserEntity> users = userService.getUser(registerUser);

        if (users != null && users.size() > 0){
            return ResponseUtils.result("0","该用户已存在，请更换手机号",userName);
        } else {

            registerUser.setPassword(password);
            int total = userService.insertUser(registerUser);
            if (total > 0) {
                UserEntity userEntity = userService.getUser(registerUser).get(0);

                UserInfoEntity userInfoEntity = new UserInfoEntity();
                userInfoEntity.setUserId(userEntity.getUserId());
                userInfoEntity.setNickName("hlj"+userName.substring(7));
                userInfoEntity.setHeadportrait("http://img.zcool.cn/community/01786557e4a6fa0000018c1bf080ca.png@2o.png");
                userInfoEntity.setMotto("本宝宝还没有签名哦");
                userInfoEntity.setPhone(userName);
                userInfoEntity.setSex(3);
                userInfoEntity.setAge("20-25");

                int flag = userInfoService.insertUserInfo(userInfoEntity);
                if (flag > 0){

                    return ResponseUtils.result("1","注册成功",userInfoEntity);
                } else  {
                    //如果插入失败，则尝试再插入一次
                    userInfoService.insertUserInfo(userInfoEntity);
                    return ResponseUtils.result("1","注册成功",userInfoEntity);
                }


            } else  {
                return ResponseUtils.result("0","当前注册人数较多，请稍等重试",userName);
            }
        }

    }

    @RequestMapping(value = "/alterPassword")
    public Map<String,Object> alterPassword(@RequestParam(value = "userName") String userName,@RequestParam(value = "newPassword") String password,@RequestParam(value = "verificationCode") String verificationCode){


        UserEntity loginInfo = new UserEntity();
        loginInfo.setUserName(userName);

        List<UserEntity> userInfos = userService.getUser(loginInfo);

        if (userInfos != null && userInfos.size() > 0){
            UserEntity userInfo = userInfos.get(0);
            userInfo.setPassword(password);
            int flag = userService.updateUser(userInfo);
            if (flag > 0){
                return ResponseUtils.result("0","修改成功",null);
            } else  {
                return ResponseUtils.result("0","修改失败，请稍后重试",null);
            }

        } else {
            return ResponseUtils.result("0","该用户不存在",null);
        }

    }

    @RequestMapping(value = "/getVerificationCode")
    public Map<String,Object> getVerificationCode(@RequestParam(value = "phone") Integer phone){


        int verificationCode = (int)((Math.random()*9+1)*100000);
        return ResponseUtils.result("0","验证码发送成功",verificationCode);

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
