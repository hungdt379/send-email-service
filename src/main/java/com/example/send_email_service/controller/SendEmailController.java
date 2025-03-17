package com.example.send_email_service.controller;

import com.example.send_email_service.service.SendEmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class SendEmailController {
    @Autowired
    SendEmailService sendEmailService;

    @GetMapping("/send-email")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) throws MessagingException, UnsupportedEncodingException {
        sendEmailService.sendEmail(to, subject, text);
        return "Email sent successfully!";
    }
}
