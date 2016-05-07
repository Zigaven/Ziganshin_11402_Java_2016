package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.MarkEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 07.05.16.
 */
@Repository
public interface MarkRepository extends JpaRepository<MarkEntity, Integer> {

    MarkEntity findOneByGeneralEntity(GeneralEntity generalEntity);

    List<MarkEntity> findAllByComics(String comics);

}
