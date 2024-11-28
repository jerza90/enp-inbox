package com.enp_inbox.enp_inbox.entity;

import com.enp_inbox.enp_inbox.audit.AbstractAuditable;
import jakarta.persistence.*;

@Entity
@Table(name="TBL_ENP_DELIVERY_TRAIL")
public class NotificationTrailEntity extends AbstractAuditable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trail_sequence"
    )
    @SequenceGenerator(
            name = "trail_sequence",
            sequenceName = "trail_sequence",
            allocationSize = 50  // Set this value consistently across all entities
    )
    private Long id;

    private String module;
    @Column(name = "notification_corr_id")  // Ensure this is mapped correctly to the column in your database
    private String notificationCorrId;
    private String status;
    private String response;
    private String outboundMsg;
    private String statusDescription;
    private String stacktrace;
    private Long partition;
    private Long offset;
    private String topic;

    public NotificationTrailEntity(){

    }

    public NotificationTrailEntity(String module, String notificationCorrId, String status, String response, String outboundMsg, String statusDescription, String stacktrace, Long partition, Long offset, String topic) {
        this.module = module;
        this.notificationCorrId = notificationCorrId;
        this.status = status;
        this.response = response;
        this.outboundMsg = outboundMsg;
        this.statusDescription = statusDescription;
        this.stacktrace = stacktrace;
        this.partition = partition;
        this.offset = offset;
        this.topic = topic;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getNotificationCorrId() {
        return notificationCorrId;
    }

    public void setNotificationCorrId(String notificationCorrId) {
        this.notificationCorrId = notificationCorrId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getOutboundMsg() {
        return outboundMsg;
    }

    public void setOutboundMsg(String outboundMsg) {
        this.outboundMsg = outboundMsg;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    public Long getPartition() {
        return partition;
    }

    public void setPartition(Long partition) {
        this.partition = partition;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
