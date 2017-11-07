package com.lqkj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lqkj.common.jsonUtils.MessageBaseBean;
import com.lqkj.domain.SignInSponsor;
import com.lqkj.service.SignSponsorService;

/**
 * Created by lijunhong on 17/11/6.
 */
@RestController
@RequestMapping("/signIn")
public class SignInSponsorController {


    @Autowired
    private SignSponsorService signSponsorService;

    /**
     * 发起签到
     * 0(代表每天)，1(代表仅一次)，2(代表工作日)，3(代表周末)，4(代表自定义)
     * @param data
     * @return
     */
    @RequestMapping(value = "/sponsor",method = RequestMethod.POST)
    public String sponsorSignIn(@RequestBody String data) {


        MessageBaseBean messageBaseBean = new MessageBaseBean();

        SignInSponsor signInSponsor = JSON.parseObject(data,SignInSponsor.class);
        if(data == null || StringUtils.isEmpty(signInSponsor.getSign_in_name()) ||
                StringUtils.isEmpty(signInSponsor.getSign_in_classify()) ||
                StringUtils.isEmpty(signInSponsor.getClassify_id()) || StringUtils.isEmpty(signInSponsor.getLatitude()) ||
                StringUtils.isEmpty(signInSponsor.getLongitude()) || StringUtils.isEmpty(signInSponsor.getStarttime()) ||
                StringUtils.isEmpty(signInSponsor.getEndtime()) || StringUtils.isEmpty(signInSponsor.getSign_place_name()) ||
                StringUtils.isEmpty(signInSponsor.getSponsor_code())||StringUtils.isEmpty(signInSponsor.getSign_in_repetition())
                || StringUtils.isEmpty(signInSponsor.getCustom_repetition())) {
            messageBaseBean.setCode(0);
            messageBaseBean.setStatus(false);
            messageBaseBean.setMessage("参数为空");
            return JSON.toJSONString(messageBaseBean);
        }

        //TODO 这里需要进行测试
        signSponsorService.saveSponsor(signInSponsor);
        messageBaseBean.setMessage("success");
        messageBaseBean.setStatus(true);
        messageBaseBean.setCode(0);
        return JSON.toJSONString(messageBaseBean);
    }
}
