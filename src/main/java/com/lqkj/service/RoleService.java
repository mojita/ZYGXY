package com.lqkj.service;

import java.util.List;

import com.lqkj.domain.Role;

/**
 * Created by lijunhong on 17/11/5.
 */
public interface RoleService {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> getRoleList();

}
