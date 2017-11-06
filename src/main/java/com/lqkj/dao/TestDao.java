package com.lqkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lqkj.common.entity.PageAble;
import com.lqkj.domain.Test;

/**
 * Created by lijunhong on 17/11/6.
 */
@Repository
public interface TestDao {

    @Select({"SELECT * FROM test LIMIT #{page.pageSize} OFFSET #{page.start}"})

    List<Test> add(@Param("page")PageAble<Test> pageAble);
}
