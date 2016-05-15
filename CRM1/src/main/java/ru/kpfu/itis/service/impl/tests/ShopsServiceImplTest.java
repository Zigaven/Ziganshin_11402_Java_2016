package ru.kpfu.itis.service.impl.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.repository.ShopRepository;
import ru.kpfu.itis.service.impl.ShopServiceImpl;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruslanzigansin on 15.05.16.
 */
public class ShopsServiceImplTest {
    private static ShopServiceImpl shopService;
    private static ShopEntity shopEntity;
    private static Page<ShopEntity> shops;
    private static PageRequest pageRequest;

    @BeforeClass
    public static void init(){
        shopService = new ShopServiceImpl();
        shopService.shopRepository=mock(ShopRepository.class);
        shopEntity = mock(ShopEntity.class);
        pageRequest = mock(PageRequest.class);
        when(shopService.shopRepository.findAll()).thenReturn((List<ShopEntity>) shops);
        when(shopService.shopRepository.findById(Long.valueOf(1))).thenReturn(shopEntity);
    }

    @Test
    public void findAllShouldReturnCorrectList() {
        Page<ShopEntity> shops = shopService.getAllShops(new PageRequest(1,5));
    }

    @Test
    public void findByIdShouldReturnCorrectOne() {
        ShopEntity shopEntity = shopService.getOneById(Long.valueOf(1));
        Assert.assertEquals(shopEntity,ShopsServiceImplTest.shopEntity);
    }


}
