package ru.kpfu.itis.service.impl.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.PersonnelProfileEntity;
import ru.kpfu.itis.repository.PersonnelProfileRepository;
import ru.kpfu.itis.service.impl.PersonnelProfileServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruslanzigansin on 15.05.16.
 */
public class PersonnelProfileServiceImplTest {
    private static PersonnelProfileServiceImpl personnelProfileService;
    private static PersonnelProfileEntity personnelProfileEntity;
    private static GeneralEntity generalEntity;

    @BeforeClass
    public static void init() {
        personnelProfileService = new PersonnelProfileServiceImpl();
        personnelProfileService.personnelProfileRepository = mock(PersonnelProfileRepository.class);
        personnelProfileEntity = mock(PersonnelProfileEntity.class);
        generalEntity = mock(GeneralEntity.class);
        when(personnelProfileService.personnelProfileRepository.findByGeneralEntity(generalEntity)).thenReturn(personnelProfileEntity);
        when(personnelProfileService.personnelProfileRepository.findOneById(43)).thenReturn(personnelProfileEntity);

    }

    @Test
    public void findByGeneralEntityShouldReturnCorrectOne() {
        PersonnelProfileEntity personnelProfileEntity = personnelProfileService.getStaffProfileEntityByStaffEntity(generalEntity);
        Assert.assertEquals(personnelProfileEntity,PersonnelProfileServiceImplTest.personnelProfileEntity);
    }

    @Test
    public void findIneByIdShouldReturnCorrectOne(){
        PersonnelProfileEntity personnelProfileEntity = personnelProfileService.getStaffProfileEntityById(43);
        Assert.assertEquals(personnelProfileEntity,PersonnelProfileServiceImplTest.personnelProfileEntity);
    }
}
