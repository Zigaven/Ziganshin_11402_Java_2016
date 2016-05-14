package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.entities.roles.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
public class RegisterForm {
    @NotEmpty(message = "Field can't be empty")
    @Size(min = 2, max = 20, message = "Max 20 symbols")
    private String firstName;

    @NotEmpty(message = "Field can't be empty")
    @Size(min = 2, max = 20, message = "Max 20 symbols")
    private String lastName;

    @Pattern(message = "Field can't be field and can't contain invalid characters", regexp = "^[a-zA-Z][a-zA-Z0-9-_\\.]{3,16}")
    private String login;

    @NotEmpty(message = "Field can't be empty")
    @Email(message = "Invalid email")
    private String email;

    @Size(min = 3, max = 15, message = "Password is not correct")
    private String password;

    @Size(min = 3, max = 15, message = "Password is not correct")
    private String repassword;

    @Enumerated(EnumType.STRING)
    private Role role;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
