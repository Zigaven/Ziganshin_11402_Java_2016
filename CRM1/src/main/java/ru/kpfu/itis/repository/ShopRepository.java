package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.form.ShopForm;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
@Repository
public interface ShopRepository extends JpaRepository<ShopEntity,Integer> {

    List<ShopEntity> findAll();

//    BigInteger getAllSalary();
//
//    BigInteger getAllLease();

    ShopEntity findById(Long id);

}
