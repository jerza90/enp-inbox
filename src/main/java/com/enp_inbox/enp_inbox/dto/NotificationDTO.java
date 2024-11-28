package com.enp_inbox.enp_inbox.dto;

import java.time.LocalDateTime;
//import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDTO {

    //        @Schema(description = "Unique correlation ID for the notification", example = "12345-corr-id")
    private String corrId;

    //        @Schema(description = "The message reference number for the notification", example = "MSG123456")
    private String messageRefNo;

    // You can uncomment and add these if needed:
    // @Schema(description = "The short code associated with the notification", example = "CA0001")
    // private String shortCode;

    // @Schema(description = "Audience of the notification, e.g., customer or system", example = "customer")
    // private String audience;

    //        @Schema(description = "Profile associated with the notification", example = "user-profile-1")
    private String profile;

    //        @Schema(description = "Mode of the notification, e.g., email, SMS, etc.", example = "1")
    private Integer mode;

    //        @Schema(description = "Time when the request for the notification was made", example = "2024-11-27T12:00:00")
    private LocalDateTime requestTime;

    // You can uncomment and add these if needed:
    // @Schema(description = "Expiry time of the notification", example = "3600")
    // private Integer expiry;

    // @Schema(description = "Callback value for the notification", example = "1")
    // private Integer callback;

    // @Schema(description = "Inbound message for the notification", example = "Inbound message text")
    // private String inboundMsg;

    //        @Schema(description = "The current status of the notification", example = "sent")
    private String status;

    public String getCorrId() {
        return corrId;
    }

    public void setCorrId(String corrId) {
        this.corrId = corrId;
    }

    public String getMessageRefNo() {
        return messageRefNo;
    }

    public void setMessageRefNo(String messageRefNo) {
        this.messageRefNo = messageRefNo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
