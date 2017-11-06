package com.lqkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lqkj.domain.SignInClassify;

/**
 * Created by lijunhong on 17/11/6.
 */
@Repository
public interface SignClassifyDao {


    @Select({
            "SELECT * from sign_in_classify WHERE is_open=true"
    })
    List<SignInClassify> getAllClassifyInfo();

}
