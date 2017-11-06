package com.lqkj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lqkj.dao.SignInSendMessageDao;
import com.lqkj.domain.SignInSendMessage;
import com.lqkj.service.SignInSendMessageService;

/**
 * Created by lijunhong on 17/11/7.
 */
@Service
public class SignInSendMessageServiceImpl implements SignInSendMessageService {

    @Autowired
    private SignInSendMessageDao sendMessageDao;

    @Override
    @Transactional
    public void saveSignSendMessage(SignInSendMessage message) {
        sendMessageDao.saveSendMessage(message);
    }
}
