package ru.kpfu.itis.service.impl.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.MarkEntity;
import ru.kpfu.itis.repository.MarkRepository;
import ru.kpfu.itis.service.impl.MarkServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruslanzigansin on 15.05.16.
 */
public class MarkServiceImplTest {
    private static MarkServiceImpl markService;
    private static MarkEntity markEntity;
    private static List<MarkEntity> marks;
    private static GeneralEntity generalEntity;

    @BeforeClass
    public static void init() {
        generalEntity = mock(GeneralEntity.class);
        markService = new MarkServiceImpl();
        markService.markRepository=mock(MarkRepository.class);
        marks = new ArrayList<MarkEntity>();
        marks.add(markEntity);
        when(markService.markRepository.findAllByComics("Comics")).thenReturn(marks);
        when(markService.markRepository.findOneByGeneralEntity(generalEntity)).thenReturn(markEntity);
    }

    @Test
    public void findAllByComicsShouldReturnCorrectList() {
        List<MarkEntity> marks = markService.getAllByComics("Comics");
        Assert.assertEquals(marks,MarkServiceImplTest.marks);
    }

    @Test
    public void findOneByGeneralEntityShouldReturnCorrectOne() {
        MarkEntity markEntity = markService.getMarkEntityByGeneralEntity(generalEntity);
        Assert.assertEquals(markEntity,MarkServiceImplTest.markEntity);
    }

}
