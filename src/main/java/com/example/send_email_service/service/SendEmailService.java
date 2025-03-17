package com.example.send_email_service.service;

import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface SendEmailService {
    void sendEmail(String to, String subject, String text) throws UnsupportedEncodingException, MessagingException;
}
