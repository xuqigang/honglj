package com.xqg.mapper;
import com.xqg.domain.VideoEntity;
import com.xqg.domain.VideoStateEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface VideoMapper {

    List<VideoEntity> getMyVideoList(@Param("userId")Integer userId,@Param("loginUserId")Integer loginUserId);

    List<VideoEntity> getFavoriteVideoList(@Param("userId")Integer userId,@Param("loginUserId")Integer loginUserId);

    List<VideoEntity> getRecommendVideoList(@Param("loginUserId")Integer loginUserId);

    List<VideoEntity> getHotVideoList(@Param("loginUserId")Integer loginUserId);

    Integer getFavoriteVideoCount(Integer userId);

    Integer getMyVideoCount(Integer userId);

    List<Map<String,Integer>> getVideosPraiseCount(List<Integer> videoIds);

    int insertVideo(VideoEntity videoEntity);

    int updateVideo(VideoEntity videoEntity);

    int updateVideoState(VideoStateEntity videoStateEntity);

}
