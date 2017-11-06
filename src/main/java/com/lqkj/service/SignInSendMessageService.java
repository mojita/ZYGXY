package com.lqkj.service;

import com.lqkj.domain.SignInSendMessage;

/**
 * Created by lijunhong on 17/11/7.
 */
public interface SignInSendMessageService {


    /**
     * 保存消息推送相关信息
     * @param message
     */
    void saveSignSendMessage(SignInSendMessage message);
}
