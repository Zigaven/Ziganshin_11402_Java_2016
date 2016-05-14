package ru.kpfu.itis.service;


import ru.kpfu.itis.entities.ComicsEntity;
import ru.kpfu.itis.form.ComicsForm;

import java.util.List;

/**
 * Created by ruslanzigansin on 02.05.16.
 */
public interface ComicsService {
    List<ComicsEntity> getAllComics();

    ComicsEntity getOneById(Integer id);
    List<ComicsEntity> getComicsByPublisher(String publisher);

    void addNewComics(ComicsForm comicsForm);

    void addNewComics(ComicsEntity comicsEntity);
}
