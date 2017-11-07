package com.lqkj.service;

import java.util.List;

import com.lqkj.common.entity.PageAble;
import com.lqkj.domain.vo.SignListVO;

/**
 * Created by lijunhong on 17/11/7.
 */
public interface SignListService {

    /**
     * 获取签到列表
     * @param code
     * @param longitude
     * @param latitude
     * @param pageAble
     * @return
     */
    List<SignListVO> getSignList(String code, float longitude, float latitude, PageAble<SignListVO> pageAble);
}
