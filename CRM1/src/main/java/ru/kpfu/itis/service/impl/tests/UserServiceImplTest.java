package ru.kpfu.itis.service.impl.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.roles.Role;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruslanzigansin on 15.05.16.
 */
public class UserServiceImplTest {
    private static UserServiceImpl userService;
    private static GeneralEntity generalEntity;
    private static List<GeneralEntity> staff;

    @BeforeClass
    public static void init() {
        userService =  new UserServiceImpl();
        userService.userRepository=mock(UserRepository.class);
        generalEntity = mock(GeneralEntity.class);
        staff = new ArrayList<GeneralEntity>();
        staff.add(generalEntity);
        generalEntity.setLogin("Login");
        when(userService.userRepository.findAllByRole(Role.ROLE_STAFF)).thenReturn(staff);
        when(userService.userRepository.findById(30)).thenReturn(generalEntity);
        when(userService.userRepository.findByLogin("Login")).thenReturn(generalEntity);
    }

    @Test
    public void findAllByRoleShouldReturnCorrectList(){
        List<GeneralEntity> staff = userService.findAllByRole(Role.ROLE_STAFF);
        Assert.assertEquals(staff,UserServiceImplTest.staff);
    }

    @Test
    public void findByIdShouldReturnCorrectOne(){
        GeneralEntity generalEntity = userService.getUserEntityById(30);
        Assert.assertEquals(generalEntity,UserServiceImplTest.generalEntity);
    }

    @Test
    public void findByLoginShouldReturnCorrectOne(){
        GeneralEntity generalEntity = userService.getUserByLogin("Login");
        Assert.assertEquals(generalEntity,UserServiceImplTest.generalEntity);
    }
}
