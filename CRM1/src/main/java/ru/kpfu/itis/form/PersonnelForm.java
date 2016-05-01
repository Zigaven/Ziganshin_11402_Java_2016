package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * Created by ruslanzigansin on 30.04.16.
 */
public class PersonnelForm {

    private String specialty;

    private String hobby;

    private String favourite;

    private Integer salary;

    @NotBlank(message = "Поле обязательно для заполнения")
    private String phone;


}
