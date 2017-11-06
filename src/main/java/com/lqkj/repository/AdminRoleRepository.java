package com.lqkj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lqkj.domain.AdminRole;

/**
 * Created by lijunhong on 17/11/5.
 * 管理员和角色中间表repository
 */
public interface AdminRoleRepository extends JpaRepository<AdminRole,Integer>{

    @Query(value = "select r.role_name from role as r where r.role_id = (select count(sba.id) from sign_backstage_admin as sba left join admin_role as ar on sba.id=ar.admin_id where sba.code=:codeValue)",nativeQuery = true)
    String isAdminRole(@Param("codeValue") String code);
}
