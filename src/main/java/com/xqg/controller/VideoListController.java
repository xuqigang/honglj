package com.xqg.controller;

import com.xqg.domain.VideoEntity;
import com.xqg.domain.VideoStateEntity;
import com.xqg.service.VideoService;
import com.xqg.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author : YaweiZhang
 * @Description :
 * @Date : Created in 19:35 2018/4/19
 * @Modified by : YaweiZhang
 * @Param :
 */
@RestController
@RequestMapping(value = "/video")
public class VideoListController {


    @Autowired
    private VideoService videoService;


    @RequestMapping(value = "/getRecommendVideoList")
    public Map<String,Object> getRecommendVideoList(@RequestParam(value = "loginUserId" ,required = false) Integer loginUserId){


        List<VideoEntity> videoList = videoService.getRecommendVideoList(loginUserId);

        videoList = setupVideoPariseCountForVideoList(videoList);

        return ResponseUtils.result("1","success",videoList);

//
    }

    @RequestMapping(value = "/getHotVideoList")
    public Map<String,Object> getHotVideoList(@RequestParam(value = "loginUserId" ,required = false) Integer loginUserId){


        List<VideoEntity> videoList = videoService.getHotVideoList(loginUserId);
        videoList = setupVideoPariseCountForVideoList(videoList);
        return ResponseUtils.result("1","success",videoList);
//
    }


    @RequestMapping(value = "/getMyVideoList")
    public Map<String,Object> getMyVideoList(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "loginUserId" ,required =false) Integer loginUserId){

        List<VideoEntity> videoList = videoService.getMyVideoList(userId,loginUserId);
        videoList = setupVideoPariseCountForVideoList(videoList);

        return ResponseUtils.result("1","success",videoList);
    }

    @RequestMapping(value = "/getFavoriteVideoList")
    public Map<String,Object> getFavoriteVideoList(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "loginUserId" ,required =false) Integer loginUserId){

        List<VideoEntity> videoList = videoService.getFavoriteVideoList(userId,loginUserId);
        videoList = setupVideoPariseCountForVideoList(videoList);
        return ResponseUtils.result("1","success",videoList);
    }

    @RequestMapping(value = "/uploadVideo")
    public Map<String,Object> uploadVideo(@RequestParam(value = "loginUserId" ) Integer loginUserId,@RequestParam(value = "title" ) String title,@RequestParam(value = "videoIntroduction" ) String videoIntroduction,@RequestParam(value = "videoUrl" ) String videoUrl,@RequestParam(value = "cover" ) String cover){

        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setUserId(loginUserId);
        videoEntity.setVideoTitle(title);
        videoEntity.setVideoIntroduction(videoIntroduction);
        videoEntity.setVideoUrl(videoUrl);
        videoEntity.setCover(cover);

        int flag = videoService.insertVideo(videoEntity);
        if (flag > 0){
            return ResponseUtils.result("1","上传成功",null);
        } else  {
            //插入失败时，尝试再次插入
            videoService.insertVideo(videoEntity);
            return ResponseUtils.result("1","上传成功",null);
        }
    }

    @RequestMapping(value = "/deleteVideo")
    public Map<String,Object> deleteVideo(@RequestParam(value = "loginUserId" ) Integer loginUserId,@RequestParam(value = "videoId" ) Integer videoId){

        VideoStateEntity videoStateEntity = new VideoStateEntity();
        videoStateEntity.setUserId(loginUserId);
        videoStateEntity.setVideoId(videoId);
        videoStateEntity.setAuditorId(loginUserId);
        videoStateEntity.setDelete(1);
        int flag = videoService.updateVideoState(videoStateEntity);
        if (flag > 0){
            return ResponseUtils.result("1","视频已删除",null);
        } else  {
            return ResponseUtils.result("0","视频删除失败",null);
        }

    }

    @RequestMapping(value = "/alterVideo")
    public Map<String,Object> alterVideo(@RequestParam(value = "loginUserId" ) Integer loginUserId,@RequestParam(value = "videoId" ) Integer videoId,@RequestParam(value = "title" ,required = false) String title,@RequestParam(value = "videoIntroduction" ,required = false) String videoIntroduction,@RequestParam(value = "cover" ,required = false) String cover){

        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setUserId(loginUserId);
        videoEntity.setVideoId(videoId);
        videoEntity.setVideoTitle(title);
        videoEntity.setVideoIntroduction(videoIntroduction);
        videoEntity.setCover(cover);

        int flag = videoService.updateVideo(videoEntity);
        if (flag > 0){
            return ResponseUtils.result("1","修改成功",null);
        } else  {
            return ResponseUtils.result("0","修改失败",null);
        }
    }

    @RequestMapping(value = "/auditVideo")
    public Map<String,Object> auditVideo(@RequestParam(value = "auditorId" ) Integer auditorId,@RequestParam(value = "videoId" ) Integer videoId,@RequestParam(value = "auditState" ) Integer auditState,@RequestParam(value = "delete" ,required = false) Integer delete){

        VideoStateEntity videoStateEntity = new VideoStateEntity();
        videoStateEntity.setVideoId(videoId);
        videoStateEntity.setAuditorId(auditorId);
        videoStateEntity.setDelete(delete);
        videoStateEntity.setAuditState(auditState);

        String message;

        if (delete != null){
            message = "视频已删除";
        } else if (auditState == 0){
            message = "视频已被拒绝";
        } else if (auditState == 1){
            message = "视频已通过";
        } else {
            message = "审核中";
        }
        int flag = videoService.updateVideoState(videoStateEntity);

        if (flag > 0){
            return ResponseUtils.result("1",message,null);
        } else  {
            return ResponseUtils.result("0","操作失败",null);
        }

    }

    private List<VideoEntity> setupVideoPariseCountForVideoList(List<VideoEntity> videoList){

        if (videoList.size() == 0){
            return videoList;
        } else {
            List<Integer> videoIds = new ArrayList<Integer>();

            for(VideoEntity attribute : videoList) {
                videoIds.add(attribute.getVideoId());
            }

            Map<Integer,Integer> videoPariseCounts = videoService.getVideosPraiseCount(videoIds);

            for(int i = 0;  i < videoList.size(); i ++) {
                VideoEntity videoEntity = videoList.get(i);

                Object count = videoPariseCounts.get(videoEntity.getVideoId());
                if (count != null) {
                    videoEntity.setFavoriteNum(Integer.valueOf(count.toString()));

                }
            }
            return videoList;
        }

    }



}
