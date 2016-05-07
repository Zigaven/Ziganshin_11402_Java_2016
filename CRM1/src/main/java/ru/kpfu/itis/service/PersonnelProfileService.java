package ru.kpfu.itis.service;

import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.PersonnelProfileEntity;
import ru.kpfu.itis.form.ProfileForm;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
public interface PersonnelProfileService {
    PersonnelProfileEntity getStaffProfileEntityById(Integer id);

    void saveNewProfile(ProfileForm profileForm, PersonnelProfileEntity staffProfileEntity, GeneralEntity generalEntity);

    PersonnelProfileEntity getStaffProfileEntityByStaffEntity(GeneralEntity staffEntity);
}
