package com.enp_inbox.enp_inbox.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_ENP_NOTIFICATION")
public class NotificationEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inbox_sequence"
    )
    @SequenceGenerator(
            name = "inbox_sequence",
            sequenceName = "inbox_sequence",
            allocationSize = 50  // Set this value consistently across all entities
    )
    private Long id;

    private String corrId;
    private String messageRefNo;
    private String shortCode;
    private String audience;
    private String profile;
    private Integer mode;
    private LocalDateTime requestTime;
    private Integer expiry;
    private Integer callback;
    private String inboundMsg;

    public NotificationEntity(){

    }

    public NotificationEntity(String corrId, String messageRefNo, String shortCode, String audience, String profile, Integer mode, LocalDateTime requestTime, Integer expiry, Integer callback, String inboundMsg) {
        this.corrId = corrId;
        this.messageRefNo = messageRefNo;
        this.shortCode = shortCode;
        this.audience = audience;
        this.profile = profile;
        this.mode = mode;
        this.requestTime = requestTime;
        this.expiry = expiry;
        this.callback = callback;
        this.inboundMsg = inboundMsg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
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

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }

    public Integer getCallback() {
        return callback;
    }

    public void setCallback(Integer callback) {
        this.callback = callback;
    }

    public String getInboundMsg() {
        return inboundMsg;
    }

    public void setInboundMsg(String inboundMsg) {
        this.inboundMsg = inboundMsg;
    }
}

