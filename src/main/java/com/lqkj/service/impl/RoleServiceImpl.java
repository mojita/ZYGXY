package com.lqkj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqkj.domain.Role;
import com.lqkj.repository.RoleRepository;
import com.lqkj.service.RoleService;

/**
 * Created by lijunhong on 17/11/5.
 * Role service
 */
@Service
public class RoleServiceImpl  implements RoleService {

    @Autowired
    private RoleRepository repository;


    @Override
    public List<Role> getRoleList() {
        return new ArrayList<Role>(repository.findAll());
    }
}
