package com.lqkj.controller.sgin;

import java.util.Hashtable;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lijunhong on 17/11/4.
 *单点登录
 *
 */
@RestController
@RequestMapping("/SinglePointSign")
public class SinglePointSign {



    private static final long serialVersionUID = 1L;

    private Control[] connCtls = null;

    @Value("${LDAP.BASEDN}")
    private String BASEDN;
    @Value("${LDAP.URL}")
    private String URL;
    @Value("${LDAP.PRINCIPAL}")
    private String PRINCIPAL;
    @Value("${LDAP.PASSWORD}")
    private String PASSWORD;


    @RequestMapping("/sign")
    public String singlePointSign() {
        String username = "2017003";  //普通测试帐号
        String password = "2017003sqn";  //普通测试帐号密码
        validata(username,password);
        return "hello";
    }


    public boolean validata(String userName,String password) {

        boolean valid = false;

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, URL + BASEDN);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, PRINCIPAL);
        env.put(Context.SECURITY_CREDENTIALS, PASSWORD);

        LdapContext ctx = null;
        String userDN = "";
        Attributes attributes = null;

        try {
            // 链接ldap
            ctx = new InitialLdapContext(env, connCtls);
            // 获取用户DN
            SearchControls constraints = new SearchControls();
            constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration en = ctx.search("", "uid=" + userName, constraints);
            while (en != null && en.hasMoreElements()) {
                Object obj = en.nextElement();
                if (obj instanceof SearchResult) {
                    SearchResult si = (SearchResult) obj;
                    userDN += si.getName();
                    userDN +=",";
                    userDN += BASEDN;
                    //获取用户信息
                    attributes = si.getAttributes();
                }
            }
            // 用户是否存在
            if (!"".equals(userDN)) {
                // 验证用户密码是否正确
                ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, userDN);
                ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, password);
                ctx.reconnect(connCtls);
                System.out.println("HHHHH:" + attributes);
                valid = true;
            } else {
                //这里获取不到用户
                System.out.println("不能找到用户,uid=" + userName);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
                ctx = null;
            }
        }
        return valid;
    }


}
