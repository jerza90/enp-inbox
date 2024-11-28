package com.enp_inbox.enp_inbox.service;

import com.enp_inbox.enp_inbox.dto.CustomerDTO;
import com.enp_inbox.enp_inbox.dto.NotificationDTO;
import com.enp_inbox.enp_inbox.dto.NotificationTrailDTO;
import com.enp_inbox.enp_inbox.entity.NotificationEntity;
import com.enp_inbox.enp_inbox.entity.CustomerEntity;
import com.enp_inbox.enp_inbox.entity.NotificationTrailEntity;
import com.enp_inbox.enp_inbox.exception.CustomerNotFoundException;
import com.enp_inbox.enp_inbox.mapper.NotificationMapper;
import com.enp_inbox.enp_inbox.projection.LatestStatusProjection;
import com.enp_inbox.enp_inbox.repo.DeliveryTrailRepository;
import com.enp_inbox.enp_inbox.repo.NotificationRepository;
import com.enp_inbox.enp_inbox.repo.CustomerCisInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.enp_inbox.enp_inbox.dto.CustomerNotificationsResponseDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerNotificationService {

    private final CustomerCisInfoRepository customerCisInfoRepository;
    private final NotificationRepository notificationRepository;
    private final DeliveryTrailRepository deliveryTrailRepository;

    @Autowired
    public CustomerNotificationService(CustomerCisInfoRepository customerCisInfoRepository, NotificationRepository notificationRepository, DeliveryTrailRepository deliveryTrailRepository) {
        this.customerCisInfoRepository = customerCisInfoRepository;
        this.notificationRepository = notificationRepository;
        this.deliveryTrailRepository = deliveryTrailRepository;
    }

    public CustomerNotificationsResponseDTO getCustomerNotifications(String cisNo, int page, int size) {

        // Fetch customer information from ENP_TBL_CIS_INFO
        CustomerEntity customerEntity = customerCisInfoRepository.findByIdentifier(cisNo);

        if (customerEntity == null) {
            throw new CustomerNotFoundException("Customer not found for cis_no: " + cisNo);
        }

        CustomerDTO customerDto = new CustomerDTO(
                customerEntity.getId(),
                customerEntity.getCustomerName(),
                customerEntity.getEmails(),
                customerEntity.getMobile()
        );

        // Define pageable object
        Pageable pageable = PageRequest.of(page, size);

        // Fetch notifications paginated
        Page<NotificationEntity> notificationsPage = notificationRepository.findByAudience(cisNo, pageable);

        // Collect all correlation IDs from the notifications
        List<String> correlationIds = notificationsPage.stream()
                .map(NotificationEntity::getCorrId)
                .filter(corrId -> corrId != null && !corrId.isEmpty())
                .collect(Collectors.toList());

        // Map to hold the latest status for each correlation ID
        Map<String, String> latestStatuses = new HashMap<>();

        if (!correlationIds.isEmpty()) {
            // Fetch the latest statuses for the correlation IDs
            List<Object[]> statusResults = deliveryTrailRepository.findLatestStatusesByCorrelationIds(correlationIds);

            // Map each correlation ID to its latest status
            for (Object[] result : statusResults) {
                String corrId = (String) result[0]; // Get the correlation ID
                String status = (String) result[1]; // Get the status
                latestStatuses.put(corrId, status); // Add to map
            }
        }

        // Convert notifications to DTOs and set the status from the map
        Page<NotificationDTO> notificationDTOS = notificationsPage.map(notification -> {
            NotificationDTO notificationDTO = NotificationMapper.toDto(notification);
            String status = latestStatuses.getOrDefault(notification.getCorrId(), "UNKNOWN");
            notificationDTO.setStatus(status); // Set status for the notification
            return notificationDTO;
        });

        // Return the response DTO with customer and paginated notifications
        return new CustomerNotificationsResponseDTO(customerDto, notificationDTOS);
    }



    // Method to get all delivery trail records for a specific corrId
    public List<NotificationTrailDTO> getDeliveryTrailRecords(String corrId) {

        List<NotificationTrailEntity> deliveryTrailEntities = deliveryTrailRepository.findByNotificationCorrId(corrId);

        // Map DeliveryTrailEntity to DeliveryTrailEntityDTO
        return deliveryTrailEntities.stream()
                .map(entity -> {
                    NotificationTrailDTO dto = new NotificationTrailDTO();
                    dto.setStatus(entity.getStatus());
                    dto.setStatusDescription(entity.getStatusDescription());
                    dto.setCreatedDate(entity.getCreatedDate());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}

