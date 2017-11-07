package com.lqkj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lqkj.domain.SignInSendMessage;

/**
 * Created by lijunhong on 17/11/7.
 */
public interface MessageRepository extends JpaRepository<SignInSendMessage,Integer>{
}
