package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.entities.GeneralEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 05.05.16.
 */
public interface UserRepository extends JpaRepository<GeneralEntity,Integer> {
    List<GeneralEntity> findAll();

    GeneralEntity findByLogin(String login);

    GeneralEntity findById(Integer id);
}
