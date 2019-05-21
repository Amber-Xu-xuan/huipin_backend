package com.qtu.zp.service;

import com.qtu.zp.domain.Collection;
import com.qtu.zp.domain.JobPosition;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/18 16:29
 */
public interface CollectionService {
    void deleteCollection(String phone,String jpId);
    void updateCollection(Collection collection);
    void addCollection(Collection collection);
    List<Collection> getCollectionByPhone(String cphone);
    Collection findCollectionByPhoneAndEName(String cphone,String eName);
    Collection findCollectionByPhoneAndjpId(String cphone,String jpId);
    List<JobPosition> getCollectJobPositionByPhone(String cphone);
}
