package com.xqg.service.impl;

import com.xqg.domain.User;
import com.xqg.domain.UserDetailsEntity;
import com.xqg.mapper.UserMapper;
import com.xqg.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetailsEntity getUserInfoByUserId(Integer userId){
        List<UserDetailsEntity> userInfoList;
        userInfoList = userMapper.getUserInfoByUserId(userId);
        if(userInfoList.size() > 0){
            return userInfoList.get(0);
        }
        return null;
    }

    @Override
    public UserDetailsEntity getUserInfoByUserName(Integer userName){
        List<UserDetailsEntity> userInfoList;
        userInfoList = userMapper.getUserInfoByUserName(userName);
        if(userInfoList.size() > 0){
            return userInfoList.get(0);
        }
        return null;
    }

    @Override
    public UserDetailsEntity getUserInfoByEntity(UserDetailsEntity user){
        List<UserDetailsEntity> userInfoList;
        userInfoList = userMapper.getUserInfoByEntity(user);
        if(userInfoList.size() > 0){
            return userInfoList.get(0);
        }
        return null;
    }
    @Override
    public int insertUser(UserDetailsEntity user){
        return userMapper.insertUser(user);
    }

    @Override
    public int updateByUserDetailsEntity(UserDetailsEntity user){
        return userMapper.updateByUserDetailsEntity(user);
    }

}
