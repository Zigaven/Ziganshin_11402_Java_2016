package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotBlank;


/**
 * Created by ruslanzigansin on 06.05.16.
 */
public class ProfileForm {

    private String favourite;

    private String hobby;

    private Integer salary;

    @NotBlank(message = "Field need to be complete")
    private String phone;

    @NotBlank(message = "Field need to be complete")
    private String specialty;

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
