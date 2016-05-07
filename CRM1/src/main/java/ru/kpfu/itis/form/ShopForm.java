package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
public class ShopForm {
    @NotEmpty(message = "Field can't be empty")
    @Size(min = 5, max = 20, message = "Max 20 symbols")
    String name;
    @NotEmpty(message = "Field can't be empty")
    @Size(min = 5, max = 30, message = "Max 30 symbols")
    String city;
//    @NotEmpty(message = "Field can't be empty")
//    @Size(min = 3, max = 6, message = "Max 6 symbols")
    Integer lease;
    @NotEmpty(message = "Field can't be empty")
    @Size(min = 5, max = 20, message = "Max 20 symbols")
    String adress;

    String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getLease() {
        return lease;
    }

    public void setLease(Integer lease) {
        this.lease = lease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
