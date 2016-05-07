package ru.kpfu.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
@Service
public class AuthenticationProvide implements AuthenticationProvider{

    @Autowired
    UserRepository userRepository;


    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();

        GeneralEntity client = userRepository.findByLogin(login);

        if (client == null) {
                throw new UsernameNotFoundException("user not found");
            }


        String password = authentication.getCredentials().toString();

        if (client != null && client.getPassword() != null) {
            if (!encoder.matches(password, client.getPassword())) {
                throw new BadCredentialsException("invalid password");
            }
        }


        List<GrantedAuthority> authorities = new ArrayList<>();
        if (client != null) {
            authorities.add(new SimpleGrantedAuthority(client.getRole().toString()));
        }


        UsernamePasswordAuthenticationToken person = null;

        if (client != null) {
            person = new UsernamePasswordAuthenticationToken(client, null, authorities);
        }

        return person;
    }



    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
