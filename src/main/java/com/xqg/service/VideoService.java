package com.xqg.service;

import com.xqg.domain.VideoEntity;
import java.util.List;

public interface VideoService {

    List<VideoEntity> getMyVideoList(int userId,int loginUserId);

    List<VideoEntity> getFavoriteVideoList(int userId,int loginUserId);

    List<VideoEntity> getRecommendVideoList(int loginUserId);

    List<VideoEntity> getHotVideoList(int loginUserId);
}
