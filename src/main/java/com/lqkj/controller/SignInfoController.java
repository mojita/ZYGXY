package com.lqkj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lqkj.common.entity.PageAble;
import com.lqkj.common.jsonUtils.MessageListBean;
import com.lqkj.domain.SignInfo;
import com.lqkj.service.SignInfoService;

/**
 * Created by lijunhong on 17/11/6.
 * 签到信息接口
 */
@RestController
@RequestMapping("/signIn")
public class SignInfoController {


    @Autowired
    private SignInfoService signInfoService;

    /**
     * 签到记录获取
     * @param code
     * @param classify
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public String getInfo(@RequestParam("code")String code,
                          @RequestParam("classify")String classify,
                          @RequestParam("page")String page,
                          @RequestParam("pageSize")String pageSize) {


        MessageListBean<SignInfo> messageListBean = new MessageListBean<>();
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(classify) ||
                StringUtils.isEmpty(page) || StringUtils.isEmpty(pageSize)) {
            messageListBean.setStatus(false);
            messageListBean.setCode(0);
            messageListBean.setMessage("参数不能为空");
            return JSON.toJSONString(messageListBean);
        }

        PageAble<SignInfo> pageAble = new PageAble<>(Integer.parseInt(page),Integer.parseInt(pageSize));
        List<SignInfo> signInfos = signInfoService.getSignInfos(code,Integer.parseInt(classify), pageAble);
//        System.out.println(signInfos.get(0));
        //TODO 不进行身份认证(该接口老师和学生都能进行调用)

        if(signInfos != null) {
            messageListBean.setCode(0);
            messageListBean.setMessage("success");
            messageListBean.setStatus(true);
            messageListBean.setData(signInfos);
            messageListBean.addPropertie("pageSize",pageAble.getPageSize());
            messageListBean.addPropertie("page",pageAble.getPage());
        }
        return JSON.toJSONString(messageListBean, SerializerFeature.WriteMapNullValue);
    }
}
