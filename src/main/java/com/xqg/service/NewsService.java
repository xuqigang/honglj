package com.xqg.service;

import com.xqg.domain.NewsEntity;

import java.util.List;

public interface NewsService {

    List<NewsEntity> selectNewsList(Integer pageIndex, Integer size);

    int insert(NewsEntity news);

    int update(NewsEntity news);

    int deleteByNewsId(Integer newsId);

}
