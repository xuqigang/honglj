package com.xqg.service.impl;

import com.xqg.domain.UserDetailsEntity;
import com.xqg.domain.UserEntity;
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
    public List<UserEntity> getUser(UserEntity user){
        return userMapper.getUser(user);
    }

    @Override
    public int insertUser(UserEntity user){
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(UserEntity user){
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(UserEntity user){
        return userMapper.updateUser(user);
    }

}
