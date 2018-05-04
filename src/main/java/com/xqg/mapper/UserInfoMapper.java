package com.xqg.mapper;

import com.xqg.domain.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {




    List<UserInfoEntity> getUserInfo(UserInfoEntity userInfo);

    int insertUserInfo(UserInfoEntity userInfo);

    int updateUserInfo(UserInfoEntity userInfo);

}
