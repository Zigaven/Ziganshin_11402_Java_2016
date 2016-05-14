package ru.kpfu.itis.repository;

import ru.kpfu.itis.entities.GeneralEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 10.05.16.
 */
public interface StaffRepository {
    List<GeneralEntity> findAllByRole(Enum Role);

}
