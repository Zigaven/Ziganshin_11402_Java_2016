package ru.kpfu.itis.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.entities.PersonnelEntity;
import ru.kpfu.itis.entities.roles.Role;
import ru.kpfu.itis.form.RegisterForm;

import java.util.Objects;

/**
 * Created by ruslanzigansin on 29.04.16.
 */
public class RegPersToUser {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static PersonnelEntity transform(RegisterForm registerForm) {
        if (registerForm == null || (!Objects.equals(registerForm.getPassword(), registerForm.getRepassword()))) {
            return null;
        }
        PersonnelEntity personnel = new PersonnelEntity();
        personnel.setFirstname(registerForm.getFirstName());
        personnel.setLastName(registerForm.getLastName());
        personnel.setEmail(registerForm.getEmail());
        personnel.setLogin(registerForm.getLogin());
        personnel.setPassword(encoder.encode(registerForm.getPassword()));
        personnel.setRole(Role.ROLE_CLIENT);
        return personnel;
    }
}
