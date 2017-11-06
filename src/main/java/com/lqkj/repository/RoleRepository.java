package com.lqkj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lqkj.domain.Role;

/**
 * Created by lijunhong on 17/11/5.
 * 角色
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
