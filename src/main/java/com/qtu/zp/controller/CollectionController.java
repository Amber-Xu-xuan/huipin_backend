package com.qtu.zp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.Collection;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.service.CollectionService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/18 16:33
 */
@RestController
@RequestMapping("/zp")
public class CollectionController {
    @Resource
    private CollectionService collectionService;

    @CrossOrigin
    @PostMapping(value = "/candidate/addCollection", produces = "application/json;charset=UTF-8")
    public Result addCollection(@RequestBody Collection collection) {
        Collection co = collectionService.findCollectionByPhoneAndjpId(collection.getCphone(),collection.getJpId());
        if (collection.getCphone() == null || collection.getCphone() == "") {
            return ResultFactory.buildFailResult("请先登录您的账号，再重新收藏本职位");
        }else if(co != null){
            return ResultFactory.buildFailResult("您已收藏过本职位");
        }  else{
            collectionService.addCollection(collection);
            String message = String.format("成功收藏。");
            return ResultFactory.buildSuccessResult(message);
        }
    }

    //删除
    @CrossOrigin
    @PostMapping(value = "/candidate/deleteCollection", produces = "application/json;charset=UTF-8")
    public Result deleteCollection(@RequestBody Collection collection) {
        collectionService.deleteCollection(collection.getCphone(),collection.getJpId());
        String message = String.format("成功取消收藏。");
        return ResultFactory.buildSuccessResult(message);
    }

    //更新
    @CrossOrigin
    @PostMapping(value = "/candidate/updateCollection", produces = "application/json;charset=UTF-8")
    public Result updateCollection(@RequestBody Collection collection) {
        collectionService.updateCollection(collection);
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }

    //    不分页查询
    @CrossOrigin
    @PostMapping(value = "candidate/getCollectionByPhone", produces = "application/json; charset=UTF-8")
    public Result getCollectionByPhone(@RequestBody String phone) {
        if (phone == "" || phone == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            List<Collection> result = collectionService.getCollectionByPhone(phone);
            return ResultFactory.buildSuccessResult(result);
        }
    }
    @CrossOrigin
    @PostMapping(value = "candidate/getCollectionListByPhone", produces = "application/json; charset=UTF-8")
    public Result getCollectionListByPhone(@RequestBody Collection collection) {
        if (collection.getCphone() == "" || collection.getCphone() == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {

            Collection result= collectionService.findCollectionByPhoneAndEName(collection.getCphone(),collection.geteName());
            return ResultFactory.buildSuccessResult(result);
        }
    }
    @CrossOrigin
    @PostMapping(value = "candidate/getCollectJobPositionByPhone", produces = "application/json; charset=UTF-8")
    public Result getCollectJobPositionByPhone(@RequestBody Collection collection) {
        if (collection.getCphone() == "" || collection.getCphone() == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            List<JobPosition> result= collectionService.getCollectJobPositionByPhone(collection.getCphone());
            return ResultFactory.buildSuccessResult(result);
        }
    }
//
}
