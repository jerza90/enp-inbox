package com.enp_inbox.enp_inbox.repo;

import com.enp_inbox.enp_inbox.entity.NotificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface NotificationRepository extends PagingAndSortingRepository<NotificationEntity, Long> {

    // Method to get paginated notifications by audience (cis_no)
    Page<NotificationEntity> findByAudience(String cisNo, Pageable pageable);
}
