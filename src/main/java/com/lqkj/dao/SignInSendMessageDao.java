package com.lqkj.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lqkj.domain.SignInSendMessage;

/**
 * Created by lijunhong on 17/11/7.
 */
@Repository
public interface SignInSendMessageDao {

    /**
     *  存入消息推送信息
     * @param message
     */
    @Insert({
            "INSERT INTO  sign_in_send_message(code,sponsor_id) value(#{message.code},#{message.sponsor_id})",
    })
    void saveSendMessage(@Param("message")SignInSendMessage message);

}
