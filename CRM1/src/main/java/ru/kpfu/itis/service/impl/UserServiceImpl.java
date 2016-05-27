package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.form.RegisterForm;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.RegClientToUser;

import java.util.List;

/**
 * Created by ruslanzigansin on 05.05.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public
    UserRepository userRepository;


    @Override
    public GeneralEntity getUserEntityById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public int createUser(RegisterForm registerForm) {
        GeneralEntity generalEntity = RegClientToUser.transform(registerForm);
        userRepository.save(generalEntity);
        return generalEntity.getId();
    }

    @Override
    public void addNewUser(GeneralEntity generalEntity) {
        userRepository.save(generalEntity);
    }

    @Override
    public List<GeneralEntity> findAllByRole(Enum Role) {
        return userRepository.findAllByRole(Role);
    }

    @Override
    public GeneralEntity getUserByLogin(String username) {
        return userRepository.findByLogin(username);
    }


}
