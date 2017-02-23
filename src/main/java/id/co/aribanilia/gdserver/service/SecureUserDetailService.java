package id.co.aribanilia.gdserver.service;

import id.co.aribanilia.gdserver.dao.PermissionDao;
import id.co.aribanilia.gdserver.dao.RolePermissionDao;
import id.co.aribanilia.gdserver.dao.UserDao;
import id.co.aribanilia.gdserver.dao.UserRoleDao;
import id.co.aribanilia.gdserver.entity.Permission;
import id.co.aribanilia.gdserver.entity.RolePermission;
import id.co.aribanilia.gdserver.entity.User;
import id.co.aribanilia.gdserver.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
@Component
public class SecureUserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Find user by username
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            //Find UserRole
            UserRole userRole = userRoleDao.findByUsername(user.getUsername());
            //Find RolePermission
            List<RolePermission> rolePermissionList = rolePermissionDao.findByRoleId(userRole.getRoleId());
            List<GrantedAuthority> authorities = buildUserAuthority(rolePermissionList);
            return buildUserForAuthentication(user, authorities);
        }
    }

    private List<GrantedAuthority> buildUserAuthority(List<RolePermission> rolePermissionList) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        for (RolePermission rolePermission : rolePermissionList) {
            Permission permission = permissionDao.findByPermissionId(rolePermission.getPermissionId());
            setAuths.add(new SimpleGrantedAuthority(permission.getPermissionType()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(setAuths);

        return grantedAuthorities;
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }
}
