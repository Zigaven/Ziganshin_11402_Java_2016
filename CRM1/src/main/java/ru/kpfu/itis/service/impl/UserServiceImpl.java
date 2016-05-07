package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.form.RegisterForm;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.RegClientToUser;

/**
 * Created by ruslanzigansin on 05.05.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public Page<GeneralEntity> getAllUsers(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest);
    }

    @Override
    public GeneralEntity getUserEntityById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void createUser(RegisterForm registerForm) {
        GeneralEntity generalEntity = RegClientToUser.transform(registerForm);
        userRepository.save(generalEntity);
    }
}
