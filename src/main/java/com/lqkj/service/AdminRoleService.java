package com.lqkj.service;

/**
 * Created by lijunhong on 17/11/5.
 */
public interface AdminRoleService {

    /**
     * 判断是否为管理员
     * @param code 职工工号/学生学号
     * @return
     */
    boolean isAdminRole(String code);
}
