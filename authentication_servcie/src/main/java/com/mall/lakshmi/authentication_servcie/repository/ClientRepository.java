package com.mall.lakshmi.authentication_servcie.repository;

import com.mall.lakshmi.authentication_servcie.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByCifNumber(String cifNumber);

}
