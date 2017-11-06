package com.lqkj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lqkj.common.jsonUtils.MessageBean;
import com.lqkj.common.jsonUtils.MessageListBean;
import com.lqkj.dao.SignClassifyDao;
import com.lqkj.domain.SignInClassify;
import com.lqkj.service.SignInClassifyService;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * Created by lijunhong on 17/11/5.
 */
@RestController
@RequestMapping("/signIn")
public class SignInClassifyController {

    @Autowired
    private SignInClassifyService classifyService;

    @Autowired
    private SignClassifyDao signClassifyDao;


    /**
     * 添加签到分类接口
     * @param data
     * @return
     */
    @RequestMapping(value = "/classify/add",method = RequestMethod.POST)
    public String addClassify(@RequestBody String data) {

        //TODO 这里还有图片上传功能,提交的时候需要等到图片上传完成才能进行提交,前台进行处理

        SignInClassify signInClassify = JSON.parseObject(data, SignInClassify.class);
        MessageBean messageBean = new MessageBean();
        if(StringUtils.isEmpty(signInClassify.getCreater_id()) ||
                StringUtils.isEmpty(signInClassify.is_open()) ||
                StringUtils.isEmpty(signInClassify.getSign_in_scope()) ||
                StringUtils.isEmpty(signInClassify.getType_name())) {
            messageBean.setMessage("请填写必填的参数");
            messageBean.setCode(0);
            messageBean.setStatus(false);
            return toJSONString(messageBean);
        }

        if(classifyService.saveSignInClassify(signInClassify,signInClassify.getCreater_id())) {
            messageBean.setCode(0);
            messageBean.setMessage("success");
            messageBean.setStatus(true);
        }else{
            messageBean.setCode(0);
            messageBean.setMessage("没有权限添加分类");
            messageBean.setStatus(false);
        }

        return toJSONString(messageBean,SerializerFeature.WriteMapNullValue);
    }

    /**
     * 删除签到分类接口
     * @param code
     * @param classifyId
     * @return
     */
    @RequestMapping(value = "/classify/delete",method = RequestMethod.GET)
    public String deleteClassify(@RequestParam("code") String code,@RequestParam("classifyId")Integer classifyId) {

        MessageBean messageBean = new MessageBean();

        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(classifyId)) {
            messageBean.setStatus(false);
            messageBean.setCode(0);
            messageBean.setMessage("参数为空");
        }

        if(classifyService.removeSignInClassify(classifyId,code)) {
            messageBean.setMessage("success");
            messageBean.setStatus(true);
            messageBean.setCode(0);
        }else {
            messageBean.setCode(0);
            messageBean.setStatus(false);
            messageBean.setMessage("删除失败");
        }

        return toJSONString(messageBean,SerializerFeature.WriteMapNullValue);
    }

    /**
     * 编辑分类接口
     * @param data
     * @return
     */
    @RequestMapping(value = "/classify/edit",method = RequestMethod.POST)
    public String edit(@RequestBody String data) {

        SignInClassify signInClassify = JSON.parseObject(data, SignInClassify.class);
        System.out.println(signInClassify.toString());
        MessageBean messageBean = new MessageBean();

        if(StringUtils.isEmpty(signInClassify.getCreater_id()) ||
                StringUtils.isEmpty(signInClassify.getSign_in_scope()) ||
                StringUtils.isEmpty(signInClassify.getId()) ||
                StringUtils.isEmpty(signInClassify.getType_name()) ||
                StringUtils.isEmpty(signInClassify.is_open())) {
            messageBean.setStatus(false);
            messageBean.setCode(0);
            messageBean.setMessage("参数为空");
            return toJSONString(messageBean);
        }

        if(classifyService.updateSignInClassify(signInClassify,signInClassify.getCreater_id())) {
            messageBean.setCode(0);
            messageBean.setMessage("success");
            messageBean.setStatus(true);
        }else{
            messageBean.setCode(0);
            messageBean.setMessage("没有权限添加分类");
            messageBean.setStatus(false);
        }

        return JSON.toJSONString(messageBean, SerializerFeature.WriteMapNullValue);
    }

    @RequestMapping(value = "/classify/getList",method = RequestMethod.GET)
    public String getSignInClassifyList(@RequestParam("code")String code) {

        MessageListBean<SignInClassify> messageBean = new MessageListBean();

        if(StringUtils.isEmpty(code)) {
            messageBean.setMessage("code参数为空");
            messageBean.setStatus(false);
            messageBean.setCode(0);
            return JSON.toJSONString(messageBean);
        }

        List<SignInClassify> signInClassifies = classifyService.getSignInClassifyAll(code);
        messageBean.setMessage("success");
        messageBean.setStatus(true);
        messageBean.setCode(0);
        if(signInClassifies.size() > 0)
            messageBean.setData(signInClassifies);

        return JSON.toJSONString(messageBean,SerializerFeature.WriteMapNullValue);
    }


    /**
     * 这里是获取签到列表,这里没有进行role角色判断
     * @param code
     * @return
     */
    @RequestMapping(value = "/classify/getClassifyListNotRole",method = RequestMethod.GET)
    public String getSignInClassifyListNotRole(@RequestParam("code")String code) {

        //TODO 这里暂时不支持用户判定
        MessageListBean<SignInClassify> messageListBean = new MessageListBean<>();

        if(StringUtils.isEmpty(code)) {
            messageListBean.setMessage("code参数不能为空");
            messageListBean.setCode(0);
            messageListBean.setStatus(false);
        }


        List<SignInClassify> signInClassifies = signClassifyDao.getAllClassifyInfo();
//        System.out.println(signInClassifies.get(2));
        if(signInClassifies == null) {
            messageListBean.setMessage("没有查询到数据");
            messageListBean.setStatus(false);
            messageListBean.setCode(0);
        }else {
            //获取导数据
            messageListBean.setCode(0);
            messageListBean.setMessage("success");
            messageListBean.setStatus(true);
            messageListBean.setData(signInClassifies);
        }

        return JSON.toJSONString(messageListBean,SerializerFeature.WriteMapNullValue);
    }

}
