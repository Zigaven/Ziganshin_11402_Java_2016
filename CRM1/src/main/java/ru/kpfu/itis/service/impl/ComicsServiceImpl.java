package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.ComicsEntity;
import ru.kpfu.itis.form.ComicsForm;
import ru.kpfu.itis.repository.ComicsRepository;
import ru.kpfu.itis.service.ComicsService;
import ru.kpfu.itis.util.RegComToUser;

import java.util.List;

/**
 * Created by ruslanzigansin on 02.05.16.
 */
@Service
public class ComicsServiceImpl implements ComicsService {
    @Qualifier("comicsRepository")
    @Autowired
    public
    ComicsRepository comicsRepository;

    @Override
    public List<ComicsEntity> getAllComics() {
        return comicsRepository.findAll();
    }

    @Override
    public ComicsEntity getOneById(Integer id) {
        return comicsRepository.findOne(Long.valueOf(id));
    }

    @Override
    public List<ComicsEntity> getComicsByPublisher(String publisher) {
        return comicsRepository.getComicsByPublisher(publisher);
    }


    @Override
    public void addNewComics(ComicsForm comicsForm) {
        ComicsEntity comicsEntity = RegComToUser.transform(comicsForm);
        comicsRepository.save(comicsEntity);

    }

    @Override
    public void addNewComics(ComicsEntity comicsEntity) {
        comicsRepository.save(comicsEntity);
    }
}
