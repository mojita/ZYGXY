package com.lqkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.lqkj.domain.SignInSponsor;

/**
 * Created by lijunhong on 17/11/6.
 */
@Repository
public interface SignInSponsorDao {

    /**
     * 这里是查询接口
     * @param code
     * @return
     */
    @Select({
            "SELECT * FROM sign_in_sponsor WHERE sponsor_code=#{code} AND is_remove=false AND classify_id=#{classifyId}"
    })
    List<SignInSponsor> getSponsorListByCode(@Param("code")String code,@Param("classifyId")Integer classfyId);

    @Update({
            "UPDATE sign_in_sponsor SET is_open=#{value} WHERE id=#{sponsorId} AND sponsor_code=#{code}"
    })
    void updateIsOpen(@Param("code")String code,@Param("sponsorId")Integer sponsorId,@Param("value")boolean value);

    @Update({
            "UPDATE sign_in_sponsor SET is_remove=#{isRemove} WHERE sponsor_code=#{code} and id=#{sponsorId}"
    })
    void updateIsRemove(@Param("isRemove")boolean isRemove,@Param("code")String code,@Param("sponsorId")Integer sponsorId);



}
