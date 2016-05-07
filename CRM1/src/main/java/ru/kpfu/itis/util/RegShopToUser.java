package ru.kpfu.itis.util;

import ru.kpfu.itis.entities.ShopEntity;
import ru.kpfu.itis.form.ShopForm;

/**
 * Created by ruslanzigansin on 29.04.16.
 */
public class RegShopToUser {

    public static ShopEntity transform(ShopForm form) {
        if (form == null) {
            return null;
        }
        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setCity(form.getCity());
        shopEntity.setAdress(form.getAdress());
        shopEntity.setLease(form.getLease());
        shopEntity.setTelephone(form.getTelephone());
        shopEntity.setName(form.getName());
        return shopEntity;
    }
}
