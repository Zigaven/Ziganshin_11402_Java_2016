package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.ShopEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
@Repository
public interface ShopRepository extends JpaRepository<ShopEntity,Integer> {

    List<ShopEntity> findAll();


    ShopEntity findById(Long id);

}
