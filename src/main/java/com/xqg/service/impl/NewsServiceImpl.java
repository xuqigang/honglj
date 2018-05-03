package com.xqg.service.impl;

import com.xqg.domain.NewsEntity;
import com.xqg.mapper.NewsMapper;
import com.xqg.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {


    @Resource
    private NewsMapper newsMapper;

    @Override
    public List<NewsEntity> selectNewsList(Integer pageIndex, Integer size){
        return newsMapper.selectNewsList(pageIndex,size);
    }

    @Override
    public int insert(NewsEntity news){
        return newsMapper.insert(news);
    }

    @Override
    public int update(NewsEntity news){
        return newsMapper.update(news);
    }

    @Override
    public int deleteByNewsId(Integer newsId){
        return newsMapper.deleteByNewsId(newsId);
    }
}
