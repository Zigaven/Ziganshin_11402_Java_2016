package ru.kpfu.itis.entities;

import ru.kpfu.itis.entities.roles.Role;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
@Entity
@Table(name = "users")
public class GeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String login;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "enabled",scale = 1)
    private int enabled;

    @OneToOne
    private PersonnelProfileEntity staff_person;

    @OneToMany(mappedBy = "clientEntity")
    private List<OrdersEntity> orders;

    public List<OrdersEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }

    public PersonnelProfileEntity getStaff_person() {
        return staff_person;
    }

    public void setStaff_person(PersonnelProfileEntity staff_person) {
        this.staff_person = staff_person;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
