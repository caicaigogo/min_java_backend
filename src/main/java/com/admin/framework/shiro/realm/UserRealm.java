package com.admin.framework.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("user");
        info.addStringPermission("user:read");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        log.error("对用户进行登录验证");
        String username = (String) token.getPrincipal();
        // 示例密码，实际应从数据库加载并加密
        String password = "123456";
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}