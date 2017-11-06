package com.lqkj.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lqkj.common.entity.PageAble;
import com.lqkj.common.jsonUtils.MessageBean;
import com.lqkj.dao.SignInfoDao;
import com.lqkj.dao.TestDao;
import com.lqkj.domain.SignInClassify;
import com.lqkj.domain.SignInfo;
import com.lqkj.domain.User;
import com.lqkj.repository.TestRepository;
import com.lqkj.service.SignInClassifyService;

/**
 * Created by lijunhong on 17/11/4.
 * 测试接口
 */
@RestController
@RequestMapping("/users")
public class Test {


//    private static String BASEDN = "dc=authldap,dc=edu,dc=cn";		//baseDN
//    private static String URL = "ldap://10.10.31.14:389/";     //LDAP链接地址

//    private static String PRINCIPAL = "uid=ldap_gis,ou=Manager,dc=authldap,dc=edu,dc=cn";  //"***"处需信息化办公室分配链接LDAP的帐号
//    private static String PASSWORD = "zut_gis_2017@"; //需信息化办公室分配链接LDAP帐号的密码


//    @Value("${BASEDN}")
//    private String BASEDN;

    @Autowired
    private SignInClassifyService signInClassifyService;

    @Autowired
   private TestRepository testRepository;

    @Autowired
    private SignInfoDao signInfoDao;

    @Autowired
    private TestDao testDao;

//    @Resource
//    private TestDao testDao;

    @RequestMapping("/get")
    public String get() {
        SignInClassify signInClassify = new SignInClassify();
        signInClassify.setShow_image_url("www.baidu.com");
        signInClassifyService.saveSignInClassify(signInClassify,"");
        return "hello";
    }

    @RequestMapping("session")
    public ModelAndView getSession(HttpSession session) {
        session.setAttribute("user",new User("张飞"));
        return new ModelAndView("users/list");
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("users/index");
    }

    @RequestMapping("/test")
    public String getTestList() {
//        MessageBaseBean messageBaseBean = new MessageBaseBean();
        int pageSize = 10;
        int page = 1;
        PageAble<com.lqkj.domain.Test> testPageAble = new PageAble<>(1,10);
        List<com.lqkj.domain.Test> tests = null;
        testDao.add(testPageAble);
        MessageBean messageBaseBean = new MessageBean();

        int i = testPageAble.getPageSize();
        System.out.println(i);

        messageBaseBean.setMessage("success");
        messageBaseBean.setCode(0);
        messageBaseBean.setStatus(true);
        messageBaseBean.addPropertie("pageSize",pageSize);
        messageBaseBean.addPropertie("page",page);
        messageBaseBean.setData(tests);
        return JSON.toJSONString(messageBaseBean);
    }


    @RequestMapping("/getInfo")
    public String getInfo() {
        PageAble<SignInfo> signInfoPageAble = new PageAble<>(1,10);
        List<SignInfo> signInfos = signInfoDao.getList(signInfoPageAble);
        System.out.println(signInfos.get(0).toString());
        return null;
    }
}
