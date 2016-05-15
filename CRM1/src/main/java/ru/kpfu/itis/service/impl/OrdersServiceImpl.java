package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.GeneralEntity;
import ru.kpfu.itis.entities.OrdersEntity;
import ru.kpfu.itis.repository.ComicsRepository;
import ru.kpfu.itis.repository.OrdersRepository;
import ru.kpfu.itis.service.OrdersService;

import java.util.List;

/**
 * Created by ruslanzigansin on 10.05.16.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Qualifier("ordersRepository")
    @Autowired
    public
    OrdersRepository ordersRepository;

    @Qualifier("comicsRepository")
    @Autowired
    ComicsRepository comicsRepository;

    @Override
    public OrdersEntity getOrderById(Integer id) {
        return ordersRepository.getOneById(id);
    }

    @Override
    public void saveNewOrder(GeneralEntity person, Integer comicsId) {
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setClientEntity(person);
        ordersEntity.setComicsEntity(comicsRepository.findOne(Long.valueOf(comicsId)));
        ordersRepository.save(ordersEntity);
    }

    @Override
    public List<OrdersEntity> getAll() {
        return ordersRepository.findAll();
    }

}
