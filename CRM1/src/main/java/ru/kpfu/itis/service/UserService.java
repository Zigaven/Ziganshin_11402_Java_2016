package ru.kpfu.itis.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.form.RegisterForm;

import java.util.List;

/**
 * Created by ruslanzigansin on 05.05.16.
 */
public interface UserService {
    Page<GeneralEntity> getAllUsers(PageRequest pageRequest);

    GeneralEntity getUserEntityById(Integer id);
    @Transactional
    int createUser(RegisterForm registerForm);

    List<GeneralEntity> findAllByRole(Enum Role);

    GeneralEntity getUserByLogin(String username);
}
