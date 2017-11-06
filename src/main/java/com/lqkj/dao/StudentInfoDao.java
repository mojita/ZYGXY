package com.lqkj.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by lijunhong on 17/11/6.udentno_combine
 */
@Repository
public interface StudentInfoDao {

    /**
     * 获取所有学生的学号,这里通过视图控制了学生是否毕业
     * @return
     */
    @Select({
            "select string_agg(studentnos, ',') from view_studentno_combine"
    })
    String getAllStudentCode();
}
