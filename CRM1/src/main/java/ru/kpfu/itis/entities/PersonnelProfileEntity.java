package ru.kpfu.itis.entities;

import javax.persistence.*;

/**
 * Created by ruslanzigansin on 30.04.16.
 */
@Entity
@Table(name = "personnel_profile")
public class PersonnelProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "favourite")
    private String favourite;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "phone")
    private String phone;

    @OneToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop_id;

    @OneToOne
    @JoinColumn(name = "staff_person")
    private GeneralEntity generalEntity;

    public GeneralEntity getGeneralEntity() {
        return generalEntity;
    }

    public void setGeneralEntity(GeneralEntity generalEntity) {
        this.generalEntity = generalEntity;
    }

    public ShopEntity getShop_id() {
        return shop_id;
    }

    public void setShop_id(ShopEntity shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

//    public ShopEntity getShop_id() {
//        return shop_id;
//    }
//
//    public void setShop_id(ShopEntity shop_id) {
//        this.shop_id = shop_id;
//    }

//    @ManyToOne
//    @JoinColumn
//    @Column(name = "shop_id", nullable = false)
//    private ShopEntity shop_id;


    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }
}
