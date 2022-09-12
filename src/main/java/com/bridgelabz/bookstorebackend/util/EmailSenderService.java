package com.bridgelabz.bookstorebackend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;;
import org.springframework.mail.javamail.JavaMailSender;

//Ability to send mail in subject and body format
@Component
public class EmailSenderService {
    @Autowired
    JavaMailSender JavaMailSender;

    public void sendEmail(String toEmail, String subject, String body ) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("rushi.molkere@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        JavaMailSender.send(message);
        System.out.println("Mail sent to the User !");
    }
}
