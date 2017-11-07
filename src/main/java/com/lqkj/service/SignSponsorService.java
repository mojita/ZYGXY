package com.lqkj.service;

import java.util.List;

import com.lqkj.domain.SignInSponsor;

/**
 * Created by lijunhong on 17/11/6.
 */
public interface SignSponsorService {

    /**
     * 保存签到发起信息
     * @param signInSponsor
     */
    void saveSponsor(SignInSponsor signInSponsor);

    /**
     * 关闭发起
     * @param code          工号学号
     * @param sponsorId     发起id
     */
    void closeOrStartSponsor(String code,Integer sponsorId,boolean isOpen);

    /**
     * 删除sponsor
     * @param code
     * @param sponsor
     * @param isRemove
     */
    void removeSponsor(String code,Integer sponsor,boolean isRemove);


    /**
     * 获取sponsor列表
     * @param code
     * @return
     */
    List<SignInSponsor> getSponsorList(String code, Integer classifyId);
}
