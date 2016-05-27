package sample.entities;

/**
 * Created by ruslanzigansin on 30.04.16.
 */
public class PersonnelProfileEntity {


    private Integer id;

    private String specialty;

    private String hobby;

    private String favourite;

    private Integer salary;

    private String phone;


    private ShopEntity shop_id;


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
