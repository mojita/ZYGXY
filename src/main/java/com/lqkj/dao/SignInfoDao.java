package com.lqkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lqkj.common.entity.PageAble;
import com.lqkj.domain.SignInfo;

/**
 * Created by lijunhong on 17/11/6.
 */
@Repository
public interface SignInfoDao {


    /**
     * 这里是查询所有的签到信息,并且通过时间进行排序
     * @param code          工号学号
     * @param classifyId    分类id
     * @param pageAble      分页信息
     * @return
     */
    @Select({
            "SELECT * FROM sign_in_info WHERE sign_classify_id=#{classifyId}",
            "ORDER BY sign_starttime DESC LIMIT #{page.pageSize} offset #{page.start}"
    })
    List<SignInfo> getSignInfos(@Param("code")String code,
                                @Param("classifyId")int classifyId,
                                @Param("page")PageAble<SignInfo> pageAble);

    @Select({
            "SELECT * FROM sign_in_info WHERE sign_classify_id=3",
            "ORDER BY sign_starttime DESC LIMIT #{page.pageSize} offset #{page.start}"
    })
    List<SignInfo> getList(@Param("page")PageAble<SignInfo> page);
}
