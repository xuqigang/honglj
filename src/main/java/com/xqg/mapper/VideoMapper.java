package com.xqg.mapper;
import com.xqg.domain.VideoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {

    List<VideoEntity> getMyVideoList(@Param("userId")int userId,@Param("userId")int loginUserId);

    List<VideoEntity> getFavoriteVideoList(@Param("userId")int userId,@Param("userId")int loginUserId);

    List<VideoEntity> getRecommendVideoList(@Param("userId")int loginUserId);

    List<VideoEntity> getHotVideoList(@Param("userId")int loginUserId);

}
