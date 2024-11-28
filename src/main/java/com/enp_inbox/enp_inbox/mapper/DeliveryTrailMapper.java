package com.enp_inbox.enp_inbox.mapper;

import com.enp_inbox.enp_inbox.dto.NotificationTrailDTO;
import com.enp_inbox.enp_inbox.entity.NotificationTrailEntity;

public class DeliveryTrailMapper {
    // Method to map DeliveryTrailEntity to DeliveryTrailEntityDTO
    public static NotificationTrailDTO toDTO(NotificationTrailEntity entity) {
        if (entity == null) {
            return null;
        }

        // Creating and returning the DTO by copying properties from the entity
        NotificationTrailDTO dto = new NotificationTrailDTO();
        dto.setStatus(entity.getStatusDescription());
        dto.setStatus(entity.getStatus());
        /* dto.setStatus(entity.gets());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setAdditionalInfo(entity.getAdditionalInfo());*/  // Add other fields as needed
        return dto;
    }
}


