package ru.kpfu.itis.util;


import com.sun.xml.internal.ws.dump.LoggingDumpTube;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.PersonnelProfileEntity;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.form.ProfileForm;

/**
 * Created by ruslanzigansin on 06.05.16.
 */
public class EditPersonnelProfileForm {

    public static PersonnelProfileEntity transform(ProfileForm form, PersonnelProfileEntity personnelProfileEntity,
                                                   GeneralEntity generalEntity, ShopEntity shopEntity) {
        if (form == null) {
            return null;
        }

        if (personnelProfileEntity == null) {
            personnelProfileEntity = new PersonnelProfileEntity();
        }


        personnelProfileEntity.setFavourite(form.getFavourite());
        if (form.getSalary() != null) {
            personnelProfileEntity.setSalary(form.getSalary());
        }
        personnelProfileEntity.setGeneralEntity(generalEntity);
        personnelProfileEntity.setShop_id(shopEntity);
        personnelProfileEntity.setPhone(form.getPhone());
        personnelProfileEntity.setHobby(form.getHobby());
        personnelProfileEntity.setSpecialty(form.getSpecialty());
        return personnelProfileEntity;
    }
}
