package com.xqg.service;

import com.xqg.domain.UserDetailsEntity;
import com.xqg.domain.UserEntity;

import java.util.List;


public interface UserService {

    List<UserEntity> getUser(UserEntity user);

    int insertUser(UserEntity user);

    int updateUser(UserEntity user);

    int deleteUser(UserEntity user);

}
