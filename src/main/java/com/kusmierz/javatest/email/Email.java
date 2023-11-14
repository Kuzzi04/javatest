package com.kusmierz.javatest.email;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

// Define Email entity class to represent the email model
@Entity
public class Email {
    // Email ID will be auto-generated
    // Using generation type identity for persistence
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    private String emailFrom;
    private String emailSubject;
    private String emailBody;

    // Using List to store multiple email-addresses for (CC-)recipients
    @ElementCollection
    private List<String> emailTo;
    @ElementCollection
    private List<String> emailCC;


    @Enumerated(EnumType.STRING)
    private EmailState state;

    // Timestamps for tracking creation and last update dates
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdateDate;

    // Constructor
    public Email() {
    }

    // getters and setters, even though some of them are not used, maybe they would be used in additional methods
    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public List<String> getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(List<String> emailTo) {
        this.emailTo = emailTo;
    }

    public List<String> getEmailCC() {
        return emailCC;
    }

    public void setEmailCC(List<String> emailCC) {
        this.emailCC = emailCC;
    }

    public EmailState getState() {
        return state;
    }

    public void setState(EmailState state) {
        this.state = state;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
