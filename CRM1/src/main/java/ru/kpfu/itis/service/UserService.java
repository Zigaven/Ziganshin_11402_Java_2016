package ru.kpfu.itis.service;

import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.form.RegisterForm;

import java.util.List;

/**
 * Created by ruslanzigansin on 05.05.16.
 */
public interface UserService {

    GeneralEntity getUserEntityById(Integer id);
    @Transactional
    int createUser(RegisterForm registerForm);

    void addNewUser(GeneralEntity generalEntity);

    List<GeneralEntity> findAllByRole(Enum Role);

    GeneralEntity getUserByLogin(String username);
}
