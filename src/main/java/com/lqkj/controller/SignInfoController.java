package com.lqkj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lqkj.common.entity.PageAble;
import com.lqkj.common.jsonUtils.MessageBaseBean;
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


    /**
     * 签到接口
     * @param data
     * @return
     */
    @RequestMapping(value = "/addSignInfo",method = RequestMethod.POST)
    public String addInfo(@RequestBody String data) {
        //TODO 该接口需要获取班级,专业、系,老师需要院系code,这里需要根据coode进行查询添加到info表中
        MessageBaseBean message = new MessageBaseBean();
        if(data == null) {
            message.setStatus(false);
            message.setCode(0);
            message.setMessage("参数为空");
        }
        SignInfo signInfo = JSON.parseObject(data,SignInfo.class);
        if(StringUtils.isEmpty(signInfo.getCode())
                || StringUtils.isEmpty(signInfo.getName())
                || StringUtils.isEmpty(signInfo.getSign_place_name())
                || StringUtils.isEmpty(signInfo.getSponsor_id())
                || StringUtils.isEmpty(signInfo.getSign_longitude())
                || StringUtils.isEmpty(signInfo.getSign_latitude())
                || StringUtils.isEmpty(signInfo.getIs_teacher())) {
            message.setStatus(false);
            message.setCode(0);
            message.setMessage("参数不能为空");
        }else {
            signInfoService.addInfo(signInfo);
            message.setStatus(true);
            message.setCode(0);
            message.setMessage("success");
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            message.addPropertie("signTime",format.format(date));
        }
        return JSON.toJSONString(message);
    }
}
