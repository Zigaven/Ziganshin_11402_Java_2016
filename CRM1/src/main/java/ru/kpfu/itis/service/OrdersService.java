package ru.kpfu.itis.service;

import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.OrdersEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 10.05.16.
 */
public interface OrdersService {

    OrdersEntity getOrderById(Integer id);

    void saveNewOrder(GeneralEntity person, Integer comicsId);

    List<OrdersEntity> getAll();

}
