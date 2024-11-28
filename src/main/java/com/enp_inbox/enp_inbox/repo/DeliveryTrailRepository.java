package com.enp_inbox.enp_inbox.repo;

import com.enp_inbox.enp_inbox.entity.NotificationTrailEntity;
import com.enp_inbox.enp_inbox.projection.LatestStatusProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryTrailRepository extends JpaRepository<NotificationTrailEntity, Long> {

        @Query("SELECT dt.notificationCorrId, dt.status " +
                "FROM NotificationTrailEntity dt " +
                "WHERE dt.notificationCorrId IN :corrIds " +
                "AND dt.createdDate = (" +
                "    SELECT MAX(sub.createdDate) " +
                "    FROM NotificationTrailEntity sub " +
                "    WHERE sub.notificationCorrId = dt.notificationCorrId" +
                ")")
        List<Object[]> findLatestStatusesByCorrelationIds(@Param("corrIds") List<String> corrIds);


    // Method to find all DeliveryTrail records by corrId
    List<NotificationTrailEntity> findByNotificationCorrId(String notificationCorrId);
}
