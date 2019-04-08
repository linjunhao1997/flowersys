package com.junhow.gp.config;
import com.junhow.gp.dao.PermissionMapper;
import com.junhow.gp.dao.RoleMapper;
import com.junhow.gp.dao.UserMapper;
import com.junhow.gp.pojo.Permission;
import com.junhow.gp.pojo.Role;
import com.junhow.gp.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author linjunhao
 * @description
 * @createDate 2019/3/11 16:45
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userDao;

    @Autowired
    private RoleMapper roleDao;

    @Autowired
    private PermissionMapper permissionDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleSet = new HashSet<String>(16);
        List<Role> roleList = roleDao.getRolesByUserName(username);
        for (Role role : roleList) {
            roleSet.add(role.getRole());
        }

        List<Permission> permissionsList = permissionDao.getPermissionByUserName(username);
        for(Permission permission : permissionsList) {
            info.addStringPermission(permission.getPermission());
        }
        info.setRoles(roleSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       String userName = authenticationToken.getPrincipal().toString();
       User obj = new User();
       obj.setUsername(userName);
       User user = userDao.selectOne(obj);
       if (user != null){
           AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
            return authenticationInfo;
       } else {
           return null;
       }
    }
}
