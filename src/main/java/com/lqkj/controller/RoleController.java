package com.lqkj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lqkj.common.jsonUtils.MessageListBean;
import com.lqkj.domain.Role;
import com.lqkj.service.RoleService;

/**
 * Created by lijunhong on 17/11/5.
 * role controller
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @RequestMapping("/getList")
    public String getList() {
        MessageListBean<Role> rolesMessage = new MessageListBean<>();
        List<Role> roles = service.getRoleList();
        if(roles == null || roles.size() <= 0) {
            rolesMessage.setCode(0);
            rolesMessage.setStatus(true);
            rolesMessage.setMessage("未查询到数据");
        }else {
            rolesMessage.setData(roles);
            rolesMessage.setCode(0);
            rolesMessage.setStatus(true);
            rolesMessage.setMessage("success");
        }
        String roleJson = JSON.toJSONString(rolesMessage);
        return roleJson;
    }

}
