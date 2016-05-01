package ru.kpfu.itis.repository;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.ShopEntity;

import java.math.BigInteger;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
@Repository
public interface ShopRepository {

    BigInteger getAllSalary();

    BigInteger getAllLease();

    ShopEntity findOneById(Integer id);
}
