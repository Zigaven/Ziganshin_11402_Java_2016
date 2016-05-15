package ru.kpfu.itis.service.impl.tests;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.entities.ComicsForDownloadEntity;
import ru.kpfu.itis.repository.ComicsForDownloadRepository;
import ru.kpfu.itis.service.impl.ComicsForDownloadServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruslanzigansin on 15.05.16.
 */
public class ComicsForDownloadServiceImplTest {

    private static ComicsForDownloadServiceImpl comicsForDownloadService;
    private static List<ComicsForDownloadEntity> comics;
    private static ComicsForDownloadEntity comicsForDownload;

    @BeforeClass
    public static void init() {
        comicsForDownloadService = new ComicsForDownloadServiceImpl();
        comicsForDownloadService.comicsForDownloadRepository = mock(ComicsForDownloadRepository.class);
        comicsForDownload = mock(ComicsForDownloadEntity.class);
        comicsForDownload.setName("Name");
        comics = new ArrayList<ComicsForDownloadEntity>();
        comics.add(comicsForDownload);
        when(comicsForDownloadService.comicsForDownloadRepository.findAll()).thenReturn(comics);
        when(comicsForDownloadService.comicsForDownloadRepository.getOneByName("Name")).thenReturn(comicsForDownload);

    }

    @Test
    public void findAllShouldReturnCorrectComicsForDownloadList() {
        List<ComicsForDownloadEntity> comics = comicsForDownloadService.getComics();
        Assert.assertEquals(comics, ComicsForDownloadServiceImplTest.comics);
    }

    @Test
    public void findOneByNameShouldReturnCorrectComics() {
        ComicsForDownloadEntity comicsForDownload = comicsForDownloadService.getComicsByName("Name");
        Assert.assertEquals(comicsForDownload,ComicsForDownloadServiceImplTest.comicsForDownload);
    }
}
