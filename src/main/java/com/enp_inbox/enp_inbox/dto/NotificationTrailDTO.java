package com.enp_inbox.enp_inbox.dto;

import java.time.LocalDateTime;

public class NotificationTrailDTO {

    private NotificationDTO notificationDTO;
//    private String corrId;
private String statusDescription;
    private LocalDateTime createdDate;
    private String status;
//    private String additionalInfo;  // Add any other fields

    public NotificationTrailDTO(){

    }

    public NotificationTrailDTO(String status, LocalDateTime createdDate, String statusDescription) {
//        this.corrId = corrId;
//        this.additionalInfo = additionalInfo;
        this.statusDescription = statusDescription;
        this.createdDate = createdDate;
        this.status = status;
    }

/*    public String getCorrId() {
        return corrId;
    }

    public void setCorrId(String corrId) {
        this.corrId = corrId;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
