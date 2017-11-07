package com.lqkj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lqkj.common.entity.PageAble;
import com.lqkj.dao.SignInfoDao;
import com.lqkj.domain.SignInfo;
import com.lqkj.repository.SignInfoRepository;
import com.lqkj.service.SignInfoService;

/**
 * Created by lijunhong on 17/11/6.
 */
@Service
public class SignInfoServiceImpl implements SignInfoService {

    @Autowired
    private SignInfoDao signInfoDao;

    @Autowired
    private SignInfoRepository repository;

    @Override
    public List<SignInfo> getSignInfos(String code, int classifyId, PageAble<SignInfo> pageAble) {
        if(pageAble == null)
            return null;
        List<SignInfo> signInfos = signInfoDao.getSignInfos(code,classifyId,pageAble);
        return signInfos;
    }

    @Override
    @Transactional
    public void addInfo(SignInfo signInfo) {
        //TODO 这里在签到的时候需要查询相关的信息,班级,年级,院系,专业这些信息
        signInfo.setSign_starttime(new Date());
        repository.save(signInfo);
    }
}
