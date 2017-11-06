package com.lqkj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lqkj.domain.SignInClassify;
import com.lqkj.repository.SignInClassifyRepository;
import com.lqkj.service.SignInClassifyService;

/**
 * Created by lijunhong on 17/11/5.
 */
@Service
public class SignInClassifyServiceImpl implements SignInClassifyService {

    @Autowired
    private SignInClassifyRepository repository;

    @Autowired
    private AdminRoleServiceImpl adminRoleService;


    @Override
    @Transactional
    public boolean saveSignInClassify(SignInClassify signInClassify, String code) {
        // 添加分类的时候判断是否为超级管理员,是添加不是返回错误
        boolean isAdmin = adminRoleService.isAdminRole(code);
        if(isAdmin) {
            signInClassify.setCreate_time(new Date());
            repository.save(signInClassify);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<SignInClassify> getSignInClassifyAll(String code) {
        boolean isAdmin = adminRoleService.isAdminRole(code);
        if(isAdmin) {
            return repository.findAll();
        }else {return null;}
    }

    @Override
    @Transactional
    public boolean updateSignInClassify(SignInClassify signInClassify,String code) {
        //保存
        boolean isAdmin = adminRoleService.isAdminRole(code);
        if(isAdmin) {
            signInClassify.setCreate_time(new Date());
            repository.save(signInClassify);
            return true;
        }else {return false;}
    }

    @Override
    @Transactional
    public boolean removeSignInClassify(int id,String code) {
        if(adminRoleService.isAdminRole(code)) {
            repository.delete(id);
            return true;
        }else {return false;}
    }
}
