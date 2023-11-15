package com.kusmierz.javatest.email;

// represents API layer
// class to expose API endpoints

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {
    // injecting the EmailService for handling email-related operations
    @Autowired
    private EmailService emailService;

    // Endpoint to get all emails
    @GetMapping
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }

    // Endpoint to get email by ID
    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        Email email = emailService.getEmailById(id);
        return ResponseEntity.ok(email);
    }

    // Endpoint to get all emails with state
    @GetMapping("/state/{state}")
    public List<Email> getEmailsByState (@PathVariable String state){
        String stateUp = state.toUpperCase();
        return emailService.getEmailsByState(EmailState.valueOf(stateUp));
    }

    // Endpoint to get all emails concerning a person as receiver or cc
    @GetMapping("/to/{receiver}")
    public List<Email> getAllEmailsTo(@PathVariable String receiver) {
        return emailService.getAllEmailsTo(receiver);
    }

    // Endpoint to get all emails by sender
    @GetMapping("/from/{sender}")
    public List<Email> getEmailsByEmailFrom(@PathVariable String sender) {
        return emailService.getEmailsByEmailFrom(sender);
    }



    // Endpoint to create a new email
    @PostMapping("/new")
    public ResponseEntity<Email> createEmail(@RequestBody Email email) {
        Email createdEmail = emailService.createEmail(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmail);
    }



    // Endpoint to update an email
    @PutMapping("/{id}")
    public ResponseEntity<Email> updateEmail(@PathVariable Long id, @RequestBody Email updatedEmail) {
        // receive id of email by path and get updated email from request body
        Email updated = emailService.updateEmail(id, updatedEmail);

        // emailService.updateEmail returns either Email or null, if there is no email by this ID and state DRAFT
        // return either OK status with update email in body or NOT FOUND status without body
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PutMapping("/send{id}")
    public ResponseEntity<Email> sendMail(@PathVariable Long id){
        Email sent = emailService.sendEmail(id);
        // emailService.sendEmail returns either Email or null, if there is no email by this ID or the recent
        // state of this mail wasn't DRAFT
        // return either OK status with sent email in body or NOT FOUND status without body
        return sent != null ? ResponseEntity.ok(sent) : ResponseEntity.notFound().build();
    }



    // Endpoint to delete an email by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Email> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        // return a NO CONTENT status with no body
        return ResponseEntity.noContent().build();
    }

    // Endpoint to delete all emails
    @DeleteMapping("/all")
    public ResponseEntity<Email> deleteAllEmails() {
        emailService.deleteAllEmails();
        // return a NO CONTENT status with no body
        return ResponseEntity.noContent().build();
    }



    // Only for testing purposes
    @PostMapping("/testmails")
    public ResponseEntity<Email> createTestEmails() {
        emailService.createTestEmails();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/markasspamtest")
    public ResponseEntity<Email> markAsSpamTest() {
        emailService.markAsSpamScheduledTask();
        return ResponseEntity.ok().build();
    }

}
