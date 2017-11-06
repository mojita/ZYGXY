package com.lqkj.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lqkj.repository.AdminRoleRepository;

/**
 * Created by lijunhong on 17/11/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRoleRepositoryTest {

    @Autowired
    private AdminRoleRepository repository;

    @Test
    public void isAdminRoleTest() {
        String i = repository.isAdminRole("1040001303");
        System.out.println(i);
    }
}
