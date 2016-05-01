package ru.kpfu.itis.service;

import ru.kpfu.itis.entities.ClientEntity;
import ru.kpfu.itis.form.RegisterForm;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
public interface ClientService {


    void registerClient(RegisterForm registerForm);

    ClientEntity getClientEntityById(Integer id);

}
