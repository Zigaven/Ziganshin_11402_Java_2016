package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entities.ClientEntity;

/**
 * Created by ruslanzigansin on 24.04.16.
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {

    ClientEntity findByLogin(String login);

    ClientEntity findById(Integer id);
}
