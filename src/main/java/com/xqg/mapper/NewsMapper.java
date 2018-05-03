package com.xqg.mapper;

import com.xqg.domain.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {


    List<NewsEntity> selectNewsList(Integer pageIndex,  Integer size);

    int insert(NewsEntity news);

    int update(NewsEntity news);

    int deleteByNewsId(Integer newsId);

}
