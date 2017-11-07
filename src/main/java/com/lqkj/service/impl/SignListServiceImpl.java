package com.lqkj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqkj.common.entity.PageAble;
import com.lqkj.dao.SignListDao;
import com.lqkj.domain.vo.SignListVO;
import com.lqkj.service.SignListService;

/**
 * Created by lijunhong on 17/11/7.
 */
@Service
public class SignListServiceImpl implements SignListService {

    @Autowired
    private SignListDao signListDao;

    @Override
    public List<SignListVO> getSignList(String code, float longitude, float latitude, PageAble<SignListVO> pageAble) {
        return signListDao.getSignList(code,longitude,latitude,pageAble);
    }
}
