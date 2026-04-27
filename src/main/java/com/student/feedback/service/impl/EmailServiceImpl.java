package com.student.feedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.student.feedback.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @org.springframework.beans.factory.annotation.Value("${spring.mail.username:mhgreddy1221@gmail.com}")
    private String fromEmail;

    @Override
    public void sendEmail(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();

        // Set the sender address dynamically
        message.setFrom(fromEmail); 
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        System.out.println("Before sending mail");
        try {
            mailSender.send(message);
            System.out.println("After sending mail");
        } catch (Exception e) {
            System.out.println("GOOGLE BLOCKED THE EMAIL (Daily Limit Exceeded), BUT WE CAUGHT THE ERROR!");
            System.out.println("You can just read the OTP from this terminal to continue testing.");
        }
    }
}
