package com.lqkj.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * Created by lijunhong on 17/11/6.
 */
@Service
public interface TeacherInfoDao {

    /**
     * 查询所有老师的工号,这里没有考虑老师是否离职
     * @return
     */
    @Select({
            "SELECT teachercode FROM eas_teacherinfo;"
    })
    Set<String> getAllTeacherCode();
}
