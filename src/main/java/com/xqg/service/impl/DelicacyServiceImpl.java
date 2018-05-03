package com.xqg.service.impl;

import com.xqg.domain.DelicacyEntity;
import com.xqg.mapper.DelicacyMapper;
import com.xqg.service.DelicacyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DelicacyServiceImpl implements DelicacyService {


    @Resource
    private DelicacyMapper delicacyMapper;

    @Override
    public List<DelicacyEntity> selectNewsList(Integer pageIndex, Integer size){
        return delicacyMapper.selectNewsList(pageIndex,size);
    }

    @Override
    public int insert(DelicacyEntity delicacy){
        return delicacyMapper.insert(delicacy);
    }

    @Override
    public int update(DelicacyEntity delicacy){
        return delicacyMapper.update(delicacy);
    }

    @Override
    public int deleteByDelicacyId(Integer delicacyId){
        return delicacyMapper.deleteByDelicacyId(delicacyId);
    }

}
