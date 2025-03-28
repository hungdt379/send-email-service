package com.example.send_email_service.service.impl;

import com.example.send_email_service.service.SendEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender mailSender;

    private static final Logger logger = LoggerFactory.getLogger(SendEmailServiceImpl.class);

    @Override
    public void sendEmail(String to, String subject, String text) throws UnsupportedEncodingException, MessagingException {
        logger.info("[START] Send to: {}", to);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        helper.setFrom("hungdt3@gmail.com", "Đặng Thế Hưng"); // Đặt tên người gửi
        helper.setReplyTo("test.hungdt379@gmail.com"); // Đặt email phản hồi
        mailSender.send(message);

        logger.info("[END  ] Send to: {}", to);
    }
}
