package com.xqg.mapper;

import com.xqg.domain.UserEntity;
import com.xqg.domain.UserDetailsEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserEntity> getUser(UserEntity user);

    int insertUser(UserEntity user);

    int updateUser(UserEntity user);

}