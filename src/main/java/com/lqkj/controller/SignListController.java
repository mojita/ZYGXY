package com.lqkj.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lqkj.common.entity.PageAble;
import com.lqkj.common.jsonUtils.MessageListBean;
import com.lqkj.domain.vo.SignListVO;
import com.lqkj.service.SignListService;

/**
 * Created by lijunhong on 17/11/7.
 * 获取签到列表
 *
 */
@RestController
@RequestMapping("/sign")
public class SignListController {

    @Autowired
    private SignListService signListService;

    @RequestMapping("/getSignList")
    public String getSignList(@RequestParam("code")String code, @Param("longitude")String longitude,
                              @Param("latitude")String latitude,@Param("page")String page,@Param("pageSize")String pageSize) {

        MessageListBean<SignListVO> message = new MessageListBean<>();

        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(longitude)
                || StringUtils.isEmpty(latitude) || StringUtils.isEmpty(page)
                || StringUtils.isEmpty(pageSize)) {
            message.setCode(0);
            message.setMessage("参数为空");
            message.setStatus(false);
            return JSON.toJSONString(message);
        }

        PageAble<SignListVO> pageAble = new PageAble<>(Integer.parseInt(page),Integer.parseInt(pageSize));
        List<SignListVO> signListVOs =
                signListService.getSignList(code,Float.parseFloat(longitude),Float.parseFloat(latitude),pageAble);

        if(signListVOs != null || signListVOs.size() > 0) {
            message.setCode(0);
            message.setMessage("success");
            message.setStatus(true);
            message.setData(signListVOs);
            message.addPropertie("page",pageAble.getPage());
            message.addPropertie("pageSize",pageAble.getPageSize());
        }
        return JSON.toJSONString(message);
    }
}
