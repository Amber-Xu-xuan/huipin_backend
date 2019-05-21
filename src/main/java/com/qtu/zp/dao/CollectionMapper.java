package com.qtu.zp.dao;

import com.qtu.zp.domain.Collection;
import com.qtu.zp.domain.JobPosition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/18 16:22
 */
@Mapper
public interface CollectionMapper {
    void deleteCollection(String cphone,String jpId);
    void updateCollection(Collection collection);
    void addCollection(Collection collection);
    List<Collection> getCollectionByPhone(String cphone);
    Collection findCollectionByPhoneAndEName(String cphone,String eName);
    Collection findCollectionByPhoneAndjpId(String cphone,String jpId);
    List<JobPosition> getCollectJobPositionByPhone(String phone);
}
