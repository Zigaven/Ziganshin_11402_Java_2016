package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.MarkEntity;
import ru.kpfu.itis.repository.MarkRepository;
import ru.kpfu.itis.service.MarkService;

import java.util.List;

/**
 * Created by ruslanzigansin on 07.05.16.
 */
@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    MarkRepository markRepository;

    @Override
    public MarkEntity getMarkEntityByGeneralEntity(GeneralEntity generalEntity) {
        return markRepository.findOneByGeneralEntity(generalEntity);
    }

    @Override
    public void saveNewMark(GeneralEntity generalEntity, String comics) {
        MarkEntity markEntity = new MarkEntity();
        markEntity.setGeneralEntity(generalEntity);
        markEntity.setMark(1);
        markEntity.setComics(comics);
        markRepository.save(markEntity);
    }

    @Override
    public List<MarkEntity> getAllByComics(String comics) {
        return markRepository.findAllByComics(comics);
    }
}
