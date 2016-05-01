package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entities.PersonnelEntity;
import ru.kpfu.itis.form.RegisterForm;
import ru.kpfu.itis.repository.PersonnelRepository;
import ru.kpfu.itis.service.PersonnelService;
import ru.kpfu.itis.util.RegClientToUser;
import ru.kpfu.itis.util.RegPersToUser;

/**
 * Created by ruslanzigansin on 29.04.16.
 */
@Service
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    PersonnelRepository personnelRepository;

    @Override
    public Page<PersonnelEntity> getAllPersonnel(PageRequest pageRequest) {
        return personnelRepository.findAll(pageRequest);
    }

    @Override
    public PersonnelEntity getPersonnelEntityById(Integer id) {
        return personnelRepository.findById(id);
    }

    @Override
    @Transactional
    public void createPersonnel(RegisterForm registerForm) {
        PersonnelEntity personnelEntity = RegPersToUser.transform(registerForm);
        personnelRepository.save(personnelEntity);
    }

}
