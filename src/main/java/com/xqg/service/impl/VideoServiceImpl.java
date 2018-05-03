package com.xqg.service.impl;

import com.xqg.domain.VideoEntity;
import com.xqg.mapper.VideoMapper;
import com.xqg.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    @Override
    public List<VideoEntity> getMyVideoList(Integer userId,Integer loginUserId){

//        List<VideoEntity> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++){
//
//            VideoEntity video = new VideoEntity();
//            list.add(video);
//        }
//        v.videid AS "videoId",
//                v.userid AS "userId",
//                v.title AS "videoTitle",
//                v.introduction AS "videoIntroduction",
//                v.videourl AS "videoUrl",
//                v.category AS "category",
//                v.categoryid AS "categoryId",
//                v.cover AS "videoId",
        return videoMapper.getMyVideoList(userId,loginUserId);
    }

    @Override
    public List<VideoEntity> getFavoriteVideoList(Integer userId,Integer loginUserId){

        return videoMapper.getFavoriteVideoList(userId,loginUserId);
    }

    @Override
    public List<VideoEntity> getRecommendVideoList(Integer loginUserId){
        return videoMapper.getRecommendVideoList(loginUserId);
    }

    @Override
    public List<VideoEntity> getHotVideoList(Integer loginUserId){
        return videoMapper.getHotVideoList(loginUserId);
    }

    @Override
    public Integer getFavoriteVideoCount(Integer userId){
        return videoMapper.getFavoriteVideoCount(userId);
    }

    @Override
    public Integer getMyVideoeCount(Integer userId){
        return videoMapper.getMyVideoCount(userId);
    }

    @Override
    public Map<Integer,Integer> getVideosPraiseCount(List<Integer> videoIds){

        List<Map<String ,Integer>> list = videoMapper.getVideosPraiseCount(videoIds);

        //将返回的List转为map对象
        Map<Integer,Integer> videosPraiseNum = new HashMap<>();
        for(Map<String ,Integer> attribute : list) {
            videosPraiseNum.put(attribute.get("videoId"),attribute.get("num"));
        }
        return videosPraiseNum;
    }
}
