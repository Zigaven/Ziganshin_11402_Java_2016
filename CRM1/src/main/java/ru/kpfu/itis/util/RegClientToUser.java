package ru.kpfu.itis.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.roles.Role;
import ru.kpfu.itis.form.RegisterForm;

import java.util.Objects;

/**
 * Created by ruslanzigansin on 05.05.16.
 */
public class RegClientToUser {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static GeneralEntity transform(RegisterForm registerForm) {
        if (registerForm == null || (!Objects.equals(registerForm.getPassword(), registerForm.getRepassword()))) {
            return null;
        }
        GeneralEntity generalEntity = new GeneralEntity();
        generalEntity.setFirstname(registerForm.getFirstName());
        generalEntity.setLastName(registerForm.getLastName());
        generalEntity.setEmail(registerForm.getEmail());
        generalEntity.setLogin(registerForm.getLogin());
        generalEntity.setPassword(encoder.encode(registerForm.getPassword()));
        generalEntity.setRole(Role.ROLE_CLIENT);
        return generalEntity;
    }
}
