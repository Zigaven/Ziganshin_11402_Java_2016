package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.service.UserService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ruslanzigansin on 12.05.16.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        GeneralEntity userAccount = userService.getUserByLogin(username);

        if(userAccount == null) {
            throw new UsernameNotFoundException("user not found");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userAccount.getRole().name()));

        return new User(username,userAccount.getPassword(),authorities);
    }

}
