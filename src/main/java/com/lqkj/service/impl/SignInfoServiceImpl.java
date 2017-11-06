package com.lqkj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqkj.common.entity.PageAble;
import com.lqkj.dao.SignInfoDao;
import com.lqkj.domain.SignInfo;
import com.lqkj.service.SignInfoService;

/**
 * Created by lijunhong on 17/11/6.
 */
@Service
public class SignInfoServiceImpl implements SignInfoService {

    @Autowired
    private SignInfoDao signInfoDao;

    @Override
    public List<SignInfo> getSignInfos(String code, int classifyId, PageAble<SignInfo> pageAble) {
        if(pageAble == null)
            return null;
        List<SignInfo> signInfos = signInfoDao.getSignInfos(code,classifyId,pageAble);
        return signInfos;
    }
}
