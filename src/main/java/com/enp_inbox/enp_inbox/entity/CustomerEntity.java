package com.enp_inbox.enp_inbox.entity;

import com.enp_inbox.enp_inbox.audit.AbstractAuditable;
import jakarta.persistence.*;

@Entity
@Table(name = "TBL_PROFILE_CIS_INFO")
public class CustomerEntity extends AbstractAuditable {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 50  // Set this value consistently across all entities
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inbox_sequence"
    )
    private Long id;

    private String recordType;

    @Column(name = "identifier", unique = true, nullable = false)
    private String identifier; // Unique identifier for the customer

    private String customerName;
    private String icBusinessRegistration;
    private String premierSegmentCode;
    private String divisionCode;
    private String scheduleCode;
    private String staffIndicator;
    private String emails;
    private String mobile;

    // Default constructor (required by JPA/Hibernate)
    public CustomerEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIcBusinessRegistration() {
        return icBusinessRegistration;
    }

    public void setIcBusinessRegistration(String icBusinessRegistration) {
        this.icBusinessRegistration = icBusinessRegistration;
    }

    public String getPremierSegmentCode() {
        return premierSegmentCode;
    }

    public void setPremierSegmentCode(String premierSegmentCode) {
        this.premierSegmentCode = premierSegmentCode;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    public String getStaffIndicator() {
        return staffIndicator;
    }

    public void setStaffIndicator(String staffIndicator) {
        this.staffIndicator = staffIndicator;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
