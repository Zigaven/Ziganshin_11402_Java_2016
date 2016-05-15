package ru.kpfu.itis.service.impl.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.entities.ComicsEntity;
import ru.kpfu.itis.repository.ComicsRepository;
import ru.kpfu.itis.service.impl.ComicsServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruslanzigansin on 15.05.16.
 */
public class ComicsServiceImplTest {
    private static ComicsServiceImpl comicsService;
    private static ComicsEntity comic;
    private static List<ComicsEntity> comics;

    @BeforeClass
    public static void init() {
        comic = mock(ComicsEntity.class);
        comic.setPublisher("Publisher");
        comicsService = new ComicsServiceImpl();
        comics = new ArrayList<ComicsEntity>();
        comics.add(comic);
        comicsService.comicsRepository=mock(ComicsRepository.class);
        when(comicsService.comicsRepository.findAll()).thenReturn(comics);
        when(comicsService.comicsRepository.getComicsByPublisher("Publisher")).thenReturn(comics);
    }

    @Test
    public void findAllShouldReturnCorrectComicsList() {
        List<ComicsEntity> comics = comicsService.getAllComics();
        Assert.assertEquals(comics,ComicsServiceImplTest.comics);
    }

    @Test
    public void getComicsByPublisherShoudReturnCorrectList() {
        List<ComicsEntity> comics = comicsService.getComicsByPublisher("Publisher");
        Assert.assertEquals(comics,ComicsServiceImplTest.comics);
    }
}
