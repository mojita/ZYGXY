package com.lqkj.service;

import java.util.List;

import com.lqkj.common.entity.PageAble;
import com.lqkj.domain.SignInfo;

/**
 * Created by lijunhong on 17/11/6.
 */
public interface SignInfoService {

    /**
     * 查询签到记录,通过签到分类的id进行查询,返回通过时间排序
     * @param code
     * @param classifyId
     * @param pageAble
     * @return
     */
    List<SignInfo> getSignInfos(String code, int classifyId, PageAble<SignInfo> pageAble);

    /**
     * 添加SignInfo信息
     * @param signInfo
     */
    void addInfo(SignInfo signInfo);
}
