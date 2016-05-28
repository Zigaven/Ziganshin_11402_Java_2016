package sample.entities;


import sample.entities.roles.Role;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
public class GeneralEntity {

    private Integer id;

    private String firstName;

    private String lastName;

    private String login;

    private String email;

    private String password;

    private Role role;

    private int enabled;

    private PersonnelProfileEntity staff_person;

//    private List<OrdersEntity> orders;

//    public List<OrdersEntity> getOrders() {
//        return orders;
//    }

//    public void setOrders(List<OrdersEntity> orders) {
//        this.orders = orders;
//    }

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
