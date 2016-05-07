package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.PersonnelProfileEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 06.05.16.
 */
@Repository
public interface PersonnelProfileRepository extends JpaRepository<PersonnelProfileEntity,Integer> {
    List<PersonnelProfileEntity> findAll();

    PersonnelProfileEntity findOneById(Integer id);

    PersonnelProfileEntity findByGeneralEntity(GeneralEntity generalEntity);
}
