package com.xqg.mapper;

import com.xqg.domain.UserFollowEntity;
import com.xqg.domain.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {




    List<UserInfoEntity> getUserInfo(UserInfoEntity userInfo);

    int insertUserInfo(UserInfoEntity userInfo);

    int updateUserInfo(UserInfoEntity userInfo);

    int unfollowUser(UserFollowEntity followInfo);

    int followUser(UserFollowEntity followInfo);

    List<UserFollowEntity> getFollowInfo(UserFollowEntity followInfo);

}
