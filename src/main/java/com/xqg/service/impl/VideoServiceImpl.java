package com.xqg.service.impl;

import com.xqg.domain.VideoEntity;
import com.xqg.mapper.VideoMapper;
import com.xqg.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    @Override
    public List<VideoEntity> getMyVideoList(int userId,int loginUserId){

        List<VideoEntity> list = new ArrayList<>();
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
    public List<VideoEntity> getFavoriteVideoList(int userId,int loginUserId){

        return videoMapper.getFavoriteVideoList(userId,loginUserId);
    }

    @Override
    public List<VideoEntity> getRecommendVideoList(int loginUserId){
        return videoMapper.getRecommendVideoList(loginUserId);
    }

    @Override
    public List<VideoEntity> getHotVideoList(int loginUserId){
        return videoMapper.getHotVideoList(loginUserId);
    }

}
