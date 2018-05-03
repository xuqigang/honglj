package com.xqg.controller;

import com.xqg.domain.DelicacyEntity;
import com.xqg.service.DelicacyService;
import com.xqg.service.NewsService;
import com.xqg.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/delicacy")
public class DelicacyController {


    @Autowired
    private DelicacyService delicacyService;

    @RequestMapping(value = "/getDelicacy")
    public Map<String,Object> getDelicacy(){


        List<DelicacyEntity> delicacyList = delicacyService.selectNewsList(0,1);

        if (delicacyList.size()>0){
            return ResponseUtils.result("1","success",delicacyList.get(0));
        } else {
            return ResponseUtils.result("0","暂无数据",null);
        }
    }

    @RequestMapping(value = "/addDelicacy")
    public Map<String,Object> addDelicacy(@RequestParam(value = "userId") Integer  userId ,@RequestParam(value = "title") String  title ,@RequestParam(value = "content") String  content){


        DelicacyEntity delicacyEntity = new DelicacyEntity();
        delicacyEntity.setTitle(title);
        delicacyEntity.setContent(content);
        int flag = delicacyService.insert(delicacyEntity);

        if (flag>0){
            return ResponseUtils.result("1","success",null);
        } else {
            return ResponseUtils.result("0","添加失败",null);
        }
    }

    @RequestMapping(value = "/deleteDelicacy")
    public Map<String,Object> deleteDelicacy(@RequestParam(value = "userId") Integer  userId ,@RequestParam(value = "delicacyId") Integer  delicacyId){


        DelicacyEntity delicacyEntity = new DelicacyEntity();
        delicacyEntity.setDelicacyId(delicacyId);
        delicacyEntity.setDelete(1);
        int flag = delicacyService.update(delicacyEntity);

        if (flag>0){
            return ResponseUtils.result("1","success",null);
        } else {
            return ResponseUtils.result("0","删除失败",null);
        }
    }

    @RequestMapping(value = "/alterDelicacy")
    public Map<String,Object> alterDelicacy(@RequestParam(value = "userId") Integer  userId ,@RequestParam(value = "delicacyId") Integer  delicacyId ,@RequestParam(value = "title") String  title ,@RequestParam(value = "content") String  content){

        DelicacyEntity delicacyEntity = new DelicacyEntity();
        delicacyEntity.setDelicacyId(delicacyId);
        delicacyEntity.setTitle(title);
        delicacyEntity.setContent(content);
        int flag = delicacyService.update(delicacyEntity);

        if (flag>0){
            return ResponseUtils.result("1","修改成功",null);
        } else {
            return ResponseUtils.result("0","修改失败",null);
        }

    }

}
