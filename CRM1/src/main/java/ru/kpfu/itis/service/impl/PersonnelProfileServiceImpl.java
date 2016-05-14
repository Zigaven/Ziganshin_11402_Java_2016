package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.PersonnelProfileEntity;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.form.ProfileForm;
import ru.kpfu.itis.repository.PersonnelProfileRepository;
import ru.kpfu.itis.service.PersonnelProfileService;
import ru.kpfu.itis.service.ShopService;
import ru.kpfu.itis.util.EditPersonnelProfileForm;

/**
 * Created by ruslanzigansin on 06.05.16.
 */
@Service
public class PersonnelProfileServiceImpl implements PersonnelProfileService {

    @Qualifier("personnelProfileRepository")
    @Autowired
    PersonnelProfileRepository personnelProfileRepository;

    @Autowired
    ShopService shopService;
    @Override
    public PersonnelProfileEntity getStaffProfileEntityById(Integer id) {
        return personnelProfileRepository.findOneById(id);
    }

    @Override
    public void saveNewProfile(ProfileForm profileForm, PersonnelProfileEntity profileEntity, GeneralEntity generalEntity) {
        ShopEntity shopEntity = shopService.getOneById((long) 1);
        PersonnelProfileEntity personnelProfileEntity = EditPersonnelProfileForm.transform(profileForm, profileEntity, generalEntity,shopEntity);
        personnelProfileRepository.save(personnelProfileEntity);
    }
    @Override
    public PersonnelProfileEntity getStaffProfileEntityByStaffEntity(GeneralEntity staffEntity) {
        return personnelProfileRepository.findByGeneralEntity(staffEntity);
    }
}
