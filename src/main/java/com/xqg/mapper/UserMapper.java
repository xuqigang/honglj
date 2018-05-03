package com.xqg.mapper;

import com.xqg.domain.User;
import com.xqg.domain.UserDetailsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    List<UserDetailsEntity> getUserInfoByUserId(Integer userId);

    List<UserDetailsEntity> getUserInfoByUserName(Integer userName);

    List<UserDetailsEntity> getUserInfoByEntity(UserDetailsEntity user);

    int insertUser(UserDetailsEntity user);

    int updateByUserDetailsEntity(UserDetailsEntity user);

    List<User> selectAllUser();
}