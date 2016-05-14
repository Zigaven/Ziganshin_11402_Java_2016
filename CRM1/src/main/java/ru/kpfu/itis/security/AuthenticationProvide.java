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
public class AuthenticationProvide implements AuthenticationProvider {


    @Autowired
    UserRepository userRepository;


    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();

        GeneralEntity client = userRepository.findByLogin(login);

        if (client == null) {
            throw new UsernameNotFoundException("user not found");
        }


        String password = authentication.getCredentials().toString();

        if (!encoder.matches(password, client.getPassword())) {
            System.out.println("password");
            throw new BadCredentialsException("invalid password");
        }

        return authenticate((Authentication) client);
    }

        public static Authentication authenticate(GeneralEntity client) {
            List<GrantedAuthority> authorities = new ArrayList<>();

            authorities.add(new SimpleGrantedAuthority(client.getRole().toString()));
            return new UsernamePasswordAuthenticationToken(client, null, authorities);
        }


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
