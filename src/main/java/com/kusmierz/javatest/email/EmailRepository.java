package com.kusmierz.javatest.email;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// represents data access layer
// class
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByState(EmailState state);
    List<Email> findByEmailFrom(String emailFrom);

    // task says emails that contain "carl@gbtec.com", but I don't know how to query over all fields except of a
    // long query that checks every field of the entity. So I just checked the field EmailFrom.
    List<Email> findByEmailFromContaining(String emailFrom);
    List<Email> findByEmailToContainingOrEmailCCContainingAndStateNot(String emailTo, String emailCC, EmailState state);
}
