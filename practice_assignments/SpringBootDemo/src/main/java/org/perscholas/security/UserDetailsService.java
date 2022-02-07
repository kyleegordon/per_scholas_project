package org.perscholas.security;

import org.perscholas.database.entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public interface UserDetailsService {

    public UserDetails loadUserByUsername(String username);

}
