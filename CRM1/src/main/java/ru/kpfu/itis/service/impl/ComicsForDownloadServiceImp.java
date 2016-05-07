package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.ComicsForDownloadEntity;
import ru.kpfu.itis.repository.ComicsForDownloadRepository;
import ru.kpfu.itis.service.ComicsForDownloadService;

import java.util.List;

/**
 * Created by ruslanzigansin on 04.05.16.
 */
@Service
public class ComicsForDownloadServiceImp implements ComicsForDownloadService {
    @Autowired
    ComicsForDownloadRepository comicsForDownloadRepository;


    @Override
    public ComicsForDownloadEntity getComicsByName(String name) {
        return comicsForDownloadRepository.getOneByName(name);
    }
}
