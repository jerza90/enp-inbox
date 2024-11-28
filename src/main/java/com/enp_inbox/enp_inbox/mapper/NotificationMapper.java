package com.enp_inbox.enp_inbox.mapper;

import com.enp_inbox.enp_inbox.entity.NotificationEntity;
import com.enp_inbox.enp_inbox.dto.NotificationDTO;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationMapper {

    // Method to convert NotificationEntity to NotificationDTO
    public static NotificationDTO toDto(NotificationEntity notification) {
        if (notification == null) {
            return null; // Returning null if the entity is null
        }

        NotificationDTO notificationDTO = new NotificationDTO();

        // Mapping fields from NotificationEntity to NotificationDTO
        notificationDTO.setCorrId(notification.getCorrId());
        notificationDTO.setMessageRefNo(notification.getMessageRefNo());
        notificationDTO.setProfile(notification.getProfile());
        notificationDTO.setMode(notification.getMode());
        notificationDTO.setRequestTime(notification.getRequestTime());
//            notificationDTO.setStatus(notification.getStatus()); // Status might be set to "UNKNOWN" later

        return notificationDTO;
    }
}

