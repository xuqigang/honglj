package com.xqg.controller;

import com.xqg.domain.NewsEntity;
import com.xqg.service.NewsService;
import com.xqg.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/news")
public class NewsListController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/getNewsList")
    public Map<String,Object> login(@RequestParam(value = "pageIndex") Integer pageIndex ,@RequestParam(value = "size") Integer size ){

        return ResponseUtils.result("0","success",newsService.selectNewsList(pageIndex,size));

    }

    @RequestMapping(value = "/addNews")
    public Map<String,Object> addNews(@RequestParam(value = "title") String  title ,@RequestParam(value = "content") String  content ){

        NewsEntity news = new NewsEntity();
        news.setContent(content);
        news.setTitle(title);


        return ResponseUtils.result("0","success",newsService.insert(news));

    }

    @RequestMapping(value = "/alterNews")
    public Map<String,Object> addNews(@RequestParam(value = "newsId") Integer newsId ,@RequestParam(value = "title") String  title,@RequestParam(value = "content") String  content){

        NewsEntity news = new NewsEntity();
        news.setNewsId(newsId);
        news.setContent(content);
        news.setTitle(title);

        int flag = newsService.update(news);
        if (flag > 0){
            return ResponseUtils.result("1","修改成功",null);
        }
        else {
            return ResponseUtils.result("0","消息ID不正确",null);
        }

    }

    @RequestMapping(value = "/deleteNews")
    public Map<String,Object> deleteNews(@RequestParam(value = "newsId") Integer newsId){



        NewsEntity news = new NewsEntity();
        news.setNewsId(newsId);
        news.setDelete(1);

        int flag = newsService.update(news);
        if (flag > 0){
            return ResponseUtils.result("1","删除成功",null);
        }
        else {
            return ResponseUtils.result("0","消息ID不正确",null);
        }

    }

}
