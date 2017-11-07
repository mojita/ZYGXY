package com.lqkj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.lqkj.common.jsonUtils.MessageBaseBean;
import com.lqkj.common.jsonUtils.MessageListBean;
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
        System.out.println(signInSponsor.toString());
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


    @RequestMapping("/sponsor/getList")
    public String getSponsorList(@RequestParam("code")String code,
                                 @RequestParam("classifyId")String classifyId) {
        MessageListBean<SignInSponsor> message = new MessageListBean<>();
        System.out.println(code);
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(classifyId)) {
            message.setMessage("参数为空");
            message.setStatus(false);
            message.setCode(0);
            return JSON.toJSONString(message);
        }
        //这里需要获取数据
        List<SignInSponsor> signInSponsors = signSponsorService.getSponsorList(code,
                Integer.parseInt(classifyId));
        if(signInSponsors != null && signInSponsors.size() > 0){
            message.setMessage("success");
            message.setStatus(true);
            message.setCode(0);
            message.setData(signInSponsors);
            return JSON.toJSONString(message);
        }else {
            message.setMessage("success");
            message.setStatus(true);
            message.setCode(0);
            message.setData(signInSponsors);
        }
        return JSON.toJSONString(message);
    }

    @RequestMapping("/sponsor/close")
    public String closeSponsor(@RequestParam("code")String code,@RequestParam("id")String id,@RequestParam("isOpen")String isOpen) {

        MessageBaseBean message = new MessageBaseBean();
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(id) || StringUtils.isEmpty(isOpen)) {
            message.setCode(0);
            message.setStatus(false);
            message.setMessage("请求参数不能为空");
        }else {
            signSponsorService.closeOrStartSponsor(code,Integer.parseInt(id),Boolean.parseBoolean(isOpen));
            message.setCode(0);
            message.setStatus(true);
            message.setMessage("success");
        }
        return JSON.toJSONString(message);
    }

    @RequestMapping("/sponsor/remove")
    public String removeSponsor(@RequestParam("id")String id,@RequestParam("code")String code) {

        MessageBaseBean message = new MessageBaseBean();
        if(StringUtils.isEmpty(id) || StringUtils.isEmpty(code)) {
            message.setMessage("参数为空");
            message.setStatus(false);
            message.setCode(0);
        }else {

            message.setCode(0);
            message.setMessage("success");
            message.setStatus(true);
            signSponsorService.removeSponsor(code,Integer.parseInt(id),true);
        }
        return JSON.toJSONString(message);
    }



}
