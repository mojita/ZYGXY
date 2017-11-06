package com.lqkj.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqkj.repository.AdminRoleRepository;
import com.lqkj.service.AdminRoleService;

/**
 * Created by lijunhong on 17/11/5.
 *
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService{

    @Autowired
    private AdminRoleRepository repository;

    @Override
    public boolean isAdminRole(String code) {

        if(code == null || "".equals(code))
            return false;

        if("超级管理员".equals(repository.isAdminRole(code))) {
            return true;
        }
        return false;
    }
}
