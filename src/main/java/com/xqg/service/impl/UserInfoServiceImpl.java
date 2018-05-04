package com.xqg.service.impl;

import com.xqg.domain.UserDetailsEntity;
import com.xqg.domain.UserInfoEntity;
import com.xqg.mapper.UserInfoMapper;
import com.xqg.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfoEntity> getUserInfo(UserInfoEntity userInfo){
        return userInfoMapper.getUserInfo(userInfo);
    }

    @Override
    public int insertUserInfo(UserInfoEntity userInfo){
        return userInfoMapper.insertUserInfo(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfoEntity userInfo){
        return userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public int deleteUserInfo(UserInfoEntity user){
        return userInfoMapper.updateUserInfo(user);
    }

}
