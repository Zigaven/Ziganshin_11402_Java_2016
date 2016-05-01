package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.form.ShopForm;
import ru.kpfu.itis.repository.ShopRepository;
import ru.kpfu.itis.service.ShopService;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by ruslanzigansin on 27.04.16.
 */
//@Service
//public class ShopServiceImpl implements ShopService {
//    @Autowired
//    ShopRepository shopRepository;
//
//    @Override
//    public Page<ShopEntity> getAllShops(PageRequest pageRequest) {
//        return null;
//    }
//
//    //
////    @Override
////    public List<OfficeEntity> getAllOffice() {
////        return officeRepository.findAll();
////    }
////
//    @Override
//    public BigInteger getAllSalary() {
//        return shopRepository.getAllSalary();
//    }
//
//    @Override
//    public BigInteger getAllLease() {
//        return shopRepository.getAllLease();
//    }
//
//    @Override
//    public ShopEntity getOneById(Integer id) {
//        return shopRepository.findOneById(id);
//    }
//
//    @Override
//    public void createNewShop(ShopForm form) {
//
//    }
//}
