package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.ClientEntity;
import ru.kpfu.itis.form.RegisterForm;
import ru.kpfu.itis.repository.ClientRepository;
import ru.kpfu.itis.service.ClientService;
import ru.kpfu.itis.util.RegClientToUser;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;




    public void registerClient(RegisterForm registerForm) {
        ClientEntity clientEntity = RegClientToUser.transform(registerForm);
        clientRepository.save(clientEntity);
    }


    @Override
    public ClientEntity getClientEntityById(Integer id) {
        return clientRepository.findById(id);
    }
}
