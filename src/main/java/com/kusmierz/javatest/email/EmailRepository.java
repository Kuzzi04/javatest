package com.kusmierz.javatest.email;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// represents data access layer
// class
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByState(EmailState state);
    List<Email> findByEmailFrom(String emailFrom);
    List<Email> findByEmailFromContaining(String emailFrom);
    List<Email> findByEmailToContainingOrEmailCCContainingAndStateNot(String emailTo, String emailCC, EmailState state);
}
