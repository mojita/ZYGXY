package com.lqkj.service;

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
    void closeSponsor(String code,Integer sponsorId);
}
