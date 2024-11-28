package com.enp_inbox.enp_inbox.repo;

import com.enp_inbox.enp_inbox.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCisInfoRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByIdentifier(String identifier);
}
