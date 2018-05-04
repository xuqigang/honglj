package com.xqg.service;

import com.xqg.domain.UserFollowEntity;
import com.xqg.domain.UserInfoEntity;

import java.util.List;

public interface UserInfoService {

    List<UserInfoEntity> getUserInfo(UserInfoEntity user);

    int insertUserInfo(UserInfoEntity user);

    int updateUserInfo(UserInfoEntity user);

    int deleteUserInfo(UserInfoEntity user);

    int unfollowUser(UserFollowEntity followInfo);

    int followUser(UserFollowEntity followInfo);

    List<UserFollowEntity> getFollowInfo(UserFollowEntity followInfo);


}
