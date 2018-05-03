package com.xqg.service;

import com.xqg.domain.DelicacyEntity;

import java.util.List;

public interface DelicacyService {

    List<DelicacyEntity> selectNewsList(Integer pageIndex, Integer size);

    int insert(DelicacyEntity delicacy);

    int update(DelicacyEntity delicacy);

    int deleteByDelicacyId(Integer delicacyId);

}
