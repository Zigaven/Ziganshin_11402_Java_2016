package ru.kpfu.itis.service.impl.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.entities.OrdersEntity;
import ru.kpfu.itis.repository.OrdersRepository;
import ru.kpfu.itis.service.impl.OrdersServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruslanzigansin on 15.05.16.
 */
public class OrdersServiceImplTest {
    private static OrdersServiceImpl ordersService;
    private static OrdersEntity ordersEntity;
    private static List<OrdersEntity> orders;

    @BeforeClass
    public static void init() {
        ordersService = new OrdersServiceImpl();
        ordersService.ordersRepository=mock(OrdersRepository.class);
        ordersEntity = mock(OrdersEntity.class);
        orders = new ArrayList<OrdersEntity>();
        orders.add(ordersEntity);
        when(ordersService.ordersRepository.getOneById(33)).thenReturn(ordersEntity);
        when(ordersService.ordersRepository.findAll()).thenReturn(orders);
    }
    @Test
    public void getOneByIdShouldReturnCorrectOne(){
        OrdersEntity ordersEntity = ordersService.getOrderById(33);
        Assert.assertEquals(ordersEntity,OrdersServiceImplTest.ordersEntity);
    }

    @Test
    public void getAllShouldReturnCorrectList() {
        List<OrdersEntity> orders = ordersService.getAll();
        Assert.assertEquals(orders,OrdersServiceImplTest.orders);
    }


}
