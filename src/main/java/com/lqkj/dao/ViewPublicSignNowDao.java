package com.lqkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lqkj.domain.vo.ViewPublicSignNow;

/**
 * 当前可用签到视图查询
 */

@Repository
public interface ViewPublicSignNowDao {

    @Select({"SELECT sis.*, sism.code " +
            "FROM tsign_in_sponsor sis, tsign_in_send_message sism" +
            "WHERE tsis.is_open = TRUE " +
            "AND sis.is_remove = FALSE " +
            "AND ( ( tsis.custom_repetition LIKE '%' || EXTRACT (dow FROM now()) || '%' " +
            "AND substr('#{now}', 12) = sis.starttime)" +
            "OR ( sis.custom_repetition IS NULL " +
            "AND sis.starttime = '#{now}' )) " +
            "AND sis.id = sism.sponsor_id" +
            "AND sism.code IS NOT NULL;"
    })
    List<ViewPublicSignNow> queryPushList(@Param("now")String now);
}
