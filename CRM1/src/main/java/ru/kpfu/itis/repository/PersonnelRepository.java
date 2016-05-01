package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.PersonnelEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
@Repository
public interface PersonnelRepository extends JpaRepository<PersonnelEntity,Long> {

    List<PersonnelEntity> findAll();

    PersonnelEntity findByLogin(String login);

    PersonnelEntity findById(Integer id);

    void deleteById(Integer id);
}
