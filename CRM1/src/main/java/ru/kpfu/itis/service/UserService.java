package ru.kpfu.itis.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.form.RegisterForm;

/**
 * Created by ruslanzigansin on 05.05.16.
 */
public interface UserService {
    Page<GeneralEntity> getAllUsers(PageRequest pageRequest);

    GeneralEntity getUserEntityById(Integer id);

    void createUser(RegisterForm registerForm);
}
