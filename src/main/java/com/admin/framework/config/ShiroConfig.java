package com.admin.framework.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.admin.framework.shiro.realm.UserRealm;


@Configuration
public class ShiroConfig {

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    @Bean
    public UserRealm userRealm() {
        return  new UserRealm();
    }

    /**
     * 登录地址
     */
    @Value("${shiro.user.loginUrl}")
    private String loginUrl;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 身份认证失败，则跳转到登录页面的配置
        shiroFilterFactoryBean.setLoginUrl(loginUrl);

        // ⭐ 使用 setFilterChainDefinitionMap 配置拦截规则
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/api/users", "anon");           // 接口匿名
        filterChainDefinitionMap.put("/**", "authc");             // 其他路径需认证

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}