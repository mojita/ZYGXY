package com.lqkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lqkj.common.entity.PageAble;
import com.lqkj.domain.vo.SignListVO;

/**
 * Created by lijunhong on 17/11/7.
 * 获取签到列表信息
 */
@Repository
public interface SignListDao {


    /**
     * 这里是获取签到列表信息
     * @param code          工号/学号
     * @param longitude     经度
     * @param latitude      纬度
     * @return
     */
    @Select({
            "SELECT * from (SELECT aa.*, sii.sign_starttime FROM(SELECT *,",
            "CASE WHEN code LIKE '%${code}%' THEN 1 ELSE 0 END has_tip,ST_distance_sphere ",
            "(st_point(${longitude},${latitude}),st_point(longitude, latitude)) _distance FROM ",
            "view_public_sign_now) aa LEFT JOIN sign_in_info sii ON aa. ID = sii.sponsor_id ",
            "AND sii.code = '${code}' AND to_timestamp(to_char(now(),'yyyy-mm-dd ' || aa.starttime),",
            "'yyyy-mm-dd hh24:mi:ss') < sii.sign_starttime AND to_timestamp(to_char(now(),'yyyy-mm-dd '",
            " || aa.endtime),'yyyy-mm-dd hh24:mi:ss') > sii.sign_startTime ORDER BY aa.has_tip DESC,",
            "aa._distance) bb ORDER BY bb.sign_starttime DESC,bb.has_tip DESC,bb._distance ",
            "LIMIT ${page.pageSize} OFFSET ${page.start}"
    })
    List<SignListVO> getSignList(@Param("code")String code,
                                 @Param("longitude")float longitude,
                                 @Param("latitude")float latitude,
                                 @Param("page")PageAble<SignListVO> pageAble);
}
