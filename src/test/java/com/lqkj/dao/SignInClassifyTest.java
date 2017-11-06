package com.lqkj.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lqkj.domain.SignInClassify;
import com.lqkj.repository.TestRepository;
import com.lqkj.service.SignInClassifyService;

/**
 * Created by lijunhong on 17/11/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SignInClassifyTest {

    @Autowired
    private SignInClassifyService signInClassifyService;

    @Autowired
    private TestRepository repository;

    @Test
    public void addTest() {
        SignInClassify signInClassify = new SignInClassify();
        signInClassify.setShow_image_url("www.baidu.com");
        signInClassifyService.saveSignInClassify(signInClassify,"");
    }


    @Test
    public void add() {
        com.lqkj.domain.Test test = new com.lqkj.domain.Test();
        test.setName("nihao");
        repository.save(test);
    }

    @Test
    public void update() {
        com.lqkj.domain.Test test = new com.lqkj.domain.Test();
//        test.setName("");
        repository.save(test);

    }
}
