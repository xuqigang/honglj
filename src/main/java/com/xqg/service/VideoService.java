package com.xqg.service;

import com.xqg.domain.VideoEntity;
import com.xqg.domain.VideoPraiseEntity;
import com.xqg.domain.VideoStateEntity;

import java.util.List;
import java.util.Map;

public interface VideoService {

    List<VideoEntity> getMyVideoList(Integer userId,Integer loginUserId);

    List<VideoEntity> getFavoriteVideoList(Integer userId,Integer loginUserId);

    List<VideoEntity> getRecommendVideoList(Integer loginUserId);

    List<VideoEntity> getHotVideoList(Integer loginUserId);

    Integer getFavoriteVideoCount(Integer userId);

    Integer getMyVideoeCount(Integer userId);

    Map<Integer,Integer> getVideosPraiseCount(List<Integer> videoIds);


    int insertVideo(VideoEntity videoEntity);

    int updateVideo(VideoEntity videoEntity);

    int updateVideoState(VideoStateEntity videoStateEntity);

    int praiseVideo(VideoPraiseEntity videoPraiseEntity);

    int unPraiseVideo(VideoPraiseEntity videoPraiseEntity);

}
