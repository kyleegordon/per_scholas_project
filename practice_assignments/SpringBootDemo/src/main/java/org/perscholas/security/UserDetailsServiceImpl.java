package org.perscholas.security;

import org.perscholas.database.dao.UserDAO;
import org.perscholas.database.entity.User;
import org.perscholas.database.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found in database");
        }

        List<UserRole> userRoles = userDao.getUserRoles(user.getId());

        //check account status
        boolean accountIsEnabled = true;

        //spring security configs
        boolean accountNotExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        //setup user roles
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), accountIsEnabled,
                                                                        accountNotExpired, credentialsNonExpired, accountNonLocked, springRoles);
        }

        private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles){

            List<GrantedAuthority> authorities = new ArrayList<>();

            for (UserRole role : userRoles){
                authorities.add(new SimpleGrantedAuthority(role.getUserRole().toString()));
            }

            return authorities;
        }
}
