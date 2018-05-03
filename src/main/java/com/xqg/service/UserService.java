package com.xqg.service;

import com.xqg.domain.UserDetailsEntity;


public interface UserService {

    UserDetailsEntity getUserInfoByUserId(Integer userId);

    UserDetailsEntity getUserInfoByUserName(Integer userName);

    UserDetailsEntity getUserInfoByEntity(UserDetailsEntity user);

    int insertUser(UserDetailsEntity user);

    int updateByUserDetailsEntity(UserDetailsEntity user);

}
