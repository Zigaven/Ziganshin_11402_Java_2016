package ru.kpfu.itis.util;


import ru.kpfu.itis.entities.ComicsEntity;
import ru.kpfu.itis.form.ComicsForm;

/**
 * Created by ruslanzigansin on 02.05.16.
 */
public class RegComToUser {
    public static ComicsEntity transform(ComicsForm form) {
        if (form == null) {
            return null;
        }
        ComicsEntity comicsEntity = new ComicsEntity();
        comicsEntity.setName(form.getName());
        comicsEntity.setDescription(form.getDescription());
        comicsEntity.setPrice(form.getPrice());
        comicsEntity.setPublisher(form.getPublisher());
        comicsEntity.setPath(form.getPath());
        return comicsEntity;
    }
}
