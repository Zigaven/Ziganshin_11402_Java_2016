package ru.kpfu.itis.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.form.ShopForm;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
public interface ShopService {
    Page<ShopEntity> getAllShops(PageRequest pageRequest);

//    BigInteger getAllSalary();
//
//    BigInteger getAllLease();

    ShopEntity getOneById(Long id);

    void createNewShop(ShopForm form);


}
