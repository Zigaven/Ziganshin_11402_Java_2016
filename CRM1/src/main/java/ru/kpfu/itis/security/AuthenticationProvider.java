package ru.kpfu.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.entities.ClientEntity;
import ru.kpfu.itis.entities.PersonnelEntity;
import ru.kpfu.itis.repository.ClientRepository;
import ru.kpfu.itis.repository.PersonnelRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PersonnelRepository personnelRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();

        ClientEntity client = clientRepository.findByLogin(login);
        PersonnelEntity personnel = personnelRepository.findByLogin(login);

        if (client == null) {
            if (personnel == null) {
                throw new UsernameNotFoundException("user not found");
            }
        }

        String password = authentication.getCredentials().toString();

        if (client != null && client.getPassword() != null) {
            if (!encoder.matches(password, client.getPassword())) {
                throw new BadCredentialsException("invalid password");
            }
        }

        if (personnel != null && personnel.getPassword() != null) {
            if (!encoder.matches(password, personnel.getPassword())) {
                throw new BadCredentialsException("invalid password");
            }
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (client != null) {
            authorities.add(new SimpleGrantedAuthority(client.getRole().toString()));
        }

        if (personnel != null) {
            authorities.add(new SimpleGrantedAuthority(personnel.getRole().toString()));
        }

        UsernamePasswordAuthenticationToken person = null;

        if (client != null) {
            person = new UsernamePasswordAuthenticationToken(client, null, authorities);
        }

        if (
        personnel!= null) {
            person = new UsernamePasswordAuthenticationToken(personnel, null, authorities);
        }

        return person;
    }



    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
