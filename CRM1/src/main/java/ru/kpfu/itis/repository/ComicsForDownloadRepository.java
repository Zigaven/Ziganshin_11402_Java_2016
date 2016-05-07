package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.ComicsForDownloadEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 04.05.16.
 */
@Repository
public interface ComicsForDownloadRepository extends JpaRepository<ComicsForDownloadEntity,Integer> {
    ComicsForDownloadEntity getOneByName(String name);
}
