package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.ComicsEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 02.05.16.
 */
@Repository
public interface ComicsRepository extends JpaRepository<ComicsEntity, Integer> {
    ComicsEntity findById(Integer id);
    List<ComicsEntity> getComicsByPublisher(String publisher);
}
