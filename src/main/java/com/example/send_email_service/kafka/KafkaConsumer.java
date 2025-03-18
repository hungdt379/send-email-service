package com.example.send_email_service.kafka;

import com.example.send_email_service.service.SendEmailService;
import jakarta.mail.MessagingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class KafkaConsumer {

    @Autowired
    SendEmailService sendEmailService;

    @KafkaListener(topics = "send-email", groupId = "send-email-group")
    public void listen(ConsumerRecord<String, String> record) throws MessagingException, UnsupportedEncodingException {
        String email = record.value();
        System.out.println("Received: " + email);
        sendEmailService.sendEmail(email, "TEST KAFKA", "TEST SUCCESSFULLY");

    }
}
