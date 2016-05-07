package ru.kpfu.itis.entities;

import javax.persistence.*;

/**
 * Created by ruslanzigansin on 07.05.16.
 */
@Entity
@Table(name = "mark")
public class MarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private Integer mark;

    private String comics;

    @OneToOne
    @JoinColumn(name = "staff_person")
    private GeneralEntity generalEntity;

    public String getComics() {
        return comics;
    }

    public void setComics(String comics) {
        this.comics = comics;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public GeneralEntity getGeneralEntity() {
        return generalEntity;
    }

    public void setGeneralEntity(GeneralEntity generalEntity) {
        this.generalEntity = generalEntity;
    }
}
