package com.lqkj.service;

import java.util.List;

import com.lqkj.domain.SignInClassify;

/**
 * Created by lijunhong on 17/11/5.
 */
public interface SignInClassifyService {

    /**
     * 添加签到分类数据
      * @param signInClassify
     *  @param code 教师工号/学生学号
     */
    boolean saveSignInClassify(SignInClassify signInClassify,String code);

    /**
     * 获取签到分类信息,管理员权限限制
     * @return
     */
    List<SignInClassify> getSignInClassifyAll(String code);

    /**
     * 更行分类信息
     * @param signInClassify
     * @param code 工号/学号
     */
    boolean updateSignInClassify(SignInClassify signInClassify,String code);

    /**
     * 删除分类
     * @param id
     * @param code  工号/学号
     */
    boolean removeSignInClassify(int id,String code);



}
