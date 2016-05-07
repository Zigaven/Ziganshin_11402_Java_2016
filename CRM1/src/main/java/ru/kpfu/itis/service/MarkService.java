package ru.kpfu.itis.service;

import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.MarkEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 07.05.16.
 */
public interface MarkService {

    MarkEntity getMarkEntityByGeneralEntity(GeneralEntity generalEntity);

    void saveNewMark(GeneralEntity generalEntity, String comics);

    List<MarkEntity> getAllByComics(String comics);

}
