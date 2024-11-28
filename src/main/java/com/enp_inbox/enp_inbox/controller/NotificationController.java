package com.enp_inbox.enp_inbox.controller;

import com.enp_inbox.enp_inbox.dto.CustomerNotificationsResponseDTO;
import com.enp_inbox.enp_inbox.dto.NotificationTrailDTO;
import com.enp_inbox.enp_inbox.service.CustomerNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inbox")
public class NotificationController {

    private final CustomerNotificationService customerNotificationService;

    @Autowired
    public NotificationController(CustomerNotificationService customerNotificationService) {
        this.customerNotificationService = customerNotificationService;
    }

    @GetMapping("/notifications")
    public CustomerNotificationsResponseDTO getCustomerNotifications(
            @RequestParam("cis_no") String cisNo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return customerNotificationService.getCustomerNotifications(cisNo, page, size);
    }

    @GetMapping("/notifications-tracks")
    public List<NotificationTrailDTO> getNotificationTrail(
            @RequestParam("corr_id") String corrId) {
        return customerNotificationService.getDeliveryTrailRecords(corrId);
    }
}
