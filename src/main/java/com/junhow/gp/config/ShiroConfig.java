package com.junhow.gp.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author linjunhao
 * @description
 * @createDate 2019/3/11 16:35
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射。认证失败的页面
         shiroFilterFactoryBean.setLoginUrl("/");
        // 认证成功跳转
        shiroFilterFactoryBean.setSuccessUrl("/pages/flower/list.html");
        // 设置不满足权限时跳转的 url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/pages/404.shtml");

        // 设置拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //游客，开发权限
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/index.shtml", "authc");

        filterChainDefinitionMap.put("/pages/user/user.shtml", "roles[super]");
        filterChainDefinitionMap.put("/pages/user/role.shtml", "roles[super]");
        filterChainDefinitionMap.put("/pages/flower/list.shtml", "roles[normal]");
        filterChainDefinitionMap.put("/pages/kind/phylum.shtml", "roles[normal]");
        filterChainDefinitionMap.put("/pages/proposal/proposal.shtml", "roles[check]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }
    @Bean
    public LifecycleBeanPostProcessor lifeCycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}
