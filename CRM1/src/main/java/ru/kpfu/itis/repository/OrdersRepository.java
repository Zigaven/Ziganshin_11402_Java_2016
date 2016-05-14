package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.OrdersEntity;

/**
 * Created by ruslanzigansin on 10.05.16.
 */
@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity,Long> {
    OrdersEntity getOneById(Integer id);


}
