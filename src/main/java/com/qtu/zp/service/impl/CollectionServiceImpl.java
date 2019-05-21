package com.qtu.zp.service.impl;

import com.qtu.zp.dao.CollectionMapper;
import com.qtu.zp.dao.JobPositionMapper;
import com.qtu.zp.domain.Collection;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/18 16:30
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Resource
    CollectionMapper collectionMapper;

    @Resource
    JobPositionMapper jobPositionMapper;

    @Override
    public void deleteCollection(String phone,String jpId) {
        collectionMapper.deleteCollection(phone,jpId);
    }

    @Override
    public void updateCollection(Collection collection) {
        collectionMapper.updateCollection(collection);
    }

    @Override
    public void addCollection(Collection collection) {
        collectionMapper.addCollection(collection);
//        在职位信息表添加收藏数
        jobPositionMapper.addcollectNumByJpId(collection.getJpId());
    }

    @Override
    public List<Collection> getCollectionByPhone(String cphone) {

        return collectionMapper.getCollectionByPhone(cphone);
    }

    @Override
    public Collection findCollectionByPhoneAndEName(String cphone, String eName) {
        return collectionMapper.findCollectionByPhoneAndEName(cphone,eName);
    }

    @Override
    public Collection findCollectionByPhoneAndjpId(String cphone, String jpId) {
        return collectionMapper.findCollectionByPhoneAndjpId(cphone,jpId);
    }

    @Override
    public List<JobPosition> getCollectJobPositionByPhone(String cphone) {
        return collectionMapper.getCollectJobPositionByPhone(cphone);
    }
}
