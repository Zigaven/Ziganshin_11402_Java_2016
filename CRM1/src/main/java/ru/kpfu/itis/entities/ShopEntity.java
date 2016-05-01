package ru.kpfu.itis.entities;

import javax.persistence.*;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
@Entity
@Table(name = "shops")
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "city", nullable = false, unique = true)
    private String city;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    public Integer getLease() {
        return lease;
    }

    public void setLease(Integer lease) {
        this.lease = lease;
    }

    @Column(name = "lease", nullable = false)
    private Integer lease;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
