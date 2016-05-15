package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.form.ShopForm;
import ru.kpfu.itis.repository.ShopRepository;
import ru.kpfu.itis.service.ShopService;
import ru.kpfu.itis.util.RegShopToUser;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Qualifier("shopRepository")
    @Autowired
    public
    ShopRepository shopRepository;

    @Override
    public Page<ShopEntity> getAllShops(PageRequest pageRequest) {
        return shopRepository.findAll(pageRequest);
    }



    public ShopEntity getOneById(Long id) {
        return shopRepository.findById(id);
    }

    @Override
    public void createNewShop(ShopForm shopForm) {
        ShopEntity shopEntity = RegShopToUser.transform(shopForm);
        shopRepository.save(shopEntity);
    }
}


