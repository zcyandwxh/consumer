package com.consumer.realm;

import com.consumer.manager.EmployeeManager;
import com.consumer.manager.RoleManager;
import com.consumer.model.Employee;
import com.consumer.model.User;
import com.consumer.model.UserRoles;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/14 
 * @since V1.0
 *  
 */
@Service
public class UserRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);


//    @Resource
//    private UserService userService;
//
//    @Resource
//    private ResourcesService resourcesService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user= (User) SecurityUtils.getSubject().getPrincipal();//User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("userid",user.getId());
//        List<Resources> resourcesList = resourcesService.loadUserResources(map);
//        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        for(Resources resources: resourcesList){
//            info.addStringPermission(resources.getResurl());
//        }
//
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
//        String username = (String)token.getPrincipal();
//        User user = userService.selectByUsername(username);
//        if(user==null) throw new UnknownAccountException();
//        if (0==user.getEnable()) {
//            throw new LockedAccountException(); // 帐号锁定
//        }
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                user, //用户
//                user.getPassword(), //密码
//                ByteSource.Util.bytes(username),
//                getName()  //realm name
//        );
//        // 当验证都通过后，把用户信息放在session里
//        Session session = SecurityUtils.getSubject().getSession();
//        session.setAttribute("userSession", user);
//        session.setAttribute("userSessionId", user.getId());
//        return authenticationInfo;
        return null;
    }

//    @Autowired
//    private EmployeeManager empRepository;
//
//    @Autowired
//    private RoleManager roleManager;
//
//    public UserRolesAndPermissions doGetGroupAuthorizationInfo(Employee userInfo) {
//        Set<String> userRoles = new HashSet<>();
//        Set<String> userPermissions = new HashSet<>();
//        List<UserRoles> userRolesList = roleManager.findEmpRole(userInfo.getName());
//        if (userRolesList != null && userRolesList.size() > 0) {
//            userRoles = userRolesList.stream().map(UserRoles::getRoleName).collect(Collectors.toSet());
//        }
//        return new UserRolesAndPermissions(userRoles, userPermissions);
//    }
//
////    public UserRolesAndPermissions doGetRoleAuthorizationInfo(Employee userInfo) {
////        Set<String> userRoles = new HashSet<>();
////        Set<String> userPermissions = new HashSet<>();
////        List<UserRoles> userRolesList = roleManager.findEmpRole(userInfo.getName());
////        if (userRolesList != null && userRolesList.size() > 0) {
////            userRoles = userRolesList.stream().map(UserRoles::getRoleName).collect(Collectors.toSet());
////        }
////        return new UserRolesAndPermissions(userRoles, userPermissions);
////    }
//
//    /**
//     * 获取授权信息
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String currentLoginName = (String) principals.getPrimaryPrincipal();
//        Set<String> userRoles = new HashSet<>();
//        Set<String> userPermissions = new HashSet<>();
//        //从数据库中获取当前登录用户的详细信息
//        List<Employee> employees = empRepository.findEmpByName(currentLoginName);
//        Employee employee = null;
//        if (employees != null && employees.size() > 0) {
//            employee = employees.get(0);
////            UserRolesAndPermissions groupContainer = doGetGroupAuthorizationInfo(employee);
//            UserRolesAndPermissions roleContainer = doGetGroupAuthorizationInfo(employee);
////            userRoles.addAll(groupContainer.getUserRoles());
//            userRoles.addAll(roleContainer.getUserRoles());
////            userPermissions.addAll(groupContainer.getUserPermissions());
//            userPermissions.addAll(roleContainer.getUserPermissions());
//        } else {
//            throw new AuthorizationException();
//        }
//        //为当前用户设置角色和权限
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.addRoles(userRoles);
//        authorizationInfo.addStringPermissions(userPermissions);
//        logger.info("###【获取角色成功】[SessionId] => {}", SecurityUtils.getSubject().getSession().getId());
//        return authorizationInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        //UsernamePasswordToken对象用来存放提交的登录信息
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        //查出是否有此用户
//            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
//    }
//
//    protected class UserRolesAndPermissions {
//        Set<String> userRoles;
//        Set<String> userPermissions;
//
//        public UserRolesAndPermissions(Set<String> userRoles, Set<String> userPermissions) {
//            this.userRoles = userRoles;
//            this.userPermissions = userPermissions;
//        }
//
//        public Set<String> getUserRoles() {
//            return userRoles;
//        }
//
//        public Set<String> getUserPermissions() {
//            return userPermissions;
//        }
//    }
}


