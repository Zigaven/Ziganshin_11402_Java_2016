package ru.kpfu.itis.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.kpfu.itis.entities.PersonnelEntity;
import ru.kpfu.itis.form.RegisterForm;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
public interface PersonnelService {

    Page<PersonnelEntity> getAllPersonnel(PageRequest pageRequest);

    PersonnelEntity getPersonnelEntityById(Integer id);

    void createPersonnel(RegisterForm registerForm);
}
