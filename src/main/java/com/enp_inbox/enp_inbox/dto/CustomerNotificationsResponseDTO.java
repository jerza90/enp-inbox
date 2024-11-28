package com.enp_inbox.enp_inbox.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class CustomerNotificationsResponseDTO {

    private CustomerDTO customer;  // Changed to CustomerDto
    private Page<NotificationDTO> notifications;

    // Constructor
    public CustomerNotificationsResponseDTO(CustomerDTO customer, Page<NotificationDTO> notifications) {
        this.customer = customer;
        this.notifications = notifications;
    }

    // Getters and Setters
    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public Page<NotificationDTO> getNotifications() {
        return notifications;
    }

    public void setNotifications(Page<NotificationDTO> notifications) {
        this.notifications = notifications;
    }

}

