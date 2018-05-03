package com.xqg.mapper;

import com.xqg.domain.DelicacyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DelicacyMapper {

    List<DelicacyEntity> selectNewsList(Integer pageIndex, Integer size);

    int insert(DelicacyEntity delicacy);

    int update(DelicacyEntity delicacy);

    int deleteByDelicacyId(Integer delicacyId);

}
