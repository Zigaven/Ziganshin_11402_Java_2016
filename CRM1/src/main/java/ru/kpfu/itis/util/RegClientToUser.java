package ru.kpfu.itis.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.entities.ClientEntity;
import ru.kpfu.itis.entities.PersonnelEntity;
import ru.kpfu.itis.entities.roles.Role;
import ru.kpfu.itis.form.RegisterForm;

import java.util.Objects;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
public class RegClientToUser {
    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static ClientEntity transform(RegisterForm registerForm) {
        if (registerForm == null || (!Objects.equals(registerForm.getPassword(), registerForm.getRepassword()))) {
            return null;
        }
        ClientEntity client = new ClientEntity();
        client.setFirstname(registerForm.getFirstName());
        client.setLastName(registerForm.getLastName());
        client.setLogin(registerForm.getLogin());
        client.setEmail(registerForm.getEmail());
        client.setPassword(encoder.encode(registerForm.getPassword()));
        client.setRole(Role.ROLE_CLIENT);
        return client;
    }
}
