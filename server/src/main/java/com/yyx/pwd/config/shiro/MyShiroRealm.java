//package com.yyx.pwd.config.shiro;
//
//import com.yyx.pwd.entity.User;
//import com.yyx.pwd.service.UserService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class MyShiroRealm extends AuthorizingRealm {
//    @Autowired
//    private UserService userService;
//
//    private final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        return null;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//
//        String name = token.getUsername();
//        User user = userService.findByName(name);
//
//        if (user != null) {
//            return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
//        }
//        return null;
//    }
//}
