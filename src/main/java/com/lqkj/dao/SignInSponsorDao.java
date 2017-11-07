package com.lqkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lqkj.domain.SignInSponsor;

/**
 * Created by lijunhong on 17/11/6.
 */
@Repository
public interface SignInSponsorDao {

    @Select({
            "SELECT * FROM "
    })
    List<SignInSponsor> getSponsorListByCode(@Param("code")String code);

}
