package ru.kpfu.itis.entities;

import javax.persistence.*;

/**
 * Created by ruslanzigansin on 10.05.16.
 */
@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "staff_person")
    private GeneralEntity staffEntity;

    @ManyToOne
    @JoinColumn(name = "client_person")
    private GeneralEntity clientEntity;

    @ManyToOne
    @JoinColumn(name = "comics_id")
    private ComicsEntity comicsEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeneralEntity getStaffEntity() {
        return staffEntity;
    }

    public void setStaffEntity(GeneralEntity staffEntity) {
        this.staffEntity = staffEntity;
    }

    public GeneralEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(GeneralEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public ComicsEntity getComicsEntity() {
        return comicsEntity;
    }

    public void setComicsEntity(ComicsEntity comicsEntity) {
        this.comicsEntity = comicsEntity;
    }
}
