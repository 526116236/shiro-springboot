package com.example.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xuqd
 * @date 2021/1/6 下午 11:06:51
 */
//@Configuration的作用是将类声明为一个配置类
@Configuration
public class Shiro {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultSecurityManager subjectManager){
        ShiroFilterFactoryBean bean =new ShiroFilterFactoryBean();
        bean.setSecurityManager(subjectManager);
        Map<String,String> filer=new LinkedHashMap<>();
        /*
        * 五个固定属性：
        * anon:无需认证即可访问
        * authc:需要认证才可访问
        * user:点击"记住我"功能才可访问
        * perms：拥有权限才能访问
        * role:拥有某个角色权限才能访问
        */
        filer.put("/user/login","anon");
        filer.put("/user/update","authc");

        bean.setFilterChainDefinitionMap(filer);
        bean.setLoginUrl("/toLogin");
        return bean;
    }

    @Bean
    public DefaultSecurityManager securityManager(UserRealm userRealm){
        DefaultSecurityManager subject=new DefaultWebSecurityManager();
        subject.setRealm(userRealm);
        return subject;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
