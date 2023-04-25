package ru.prodik.zeus.services;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    @Autowired
    private Session mailSession;

    public boolean sendEmail(String toMail, String subject, String body) {

        try {
            Message message = new MimeMessage(mailSession);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            message.setFrom(new InternetAddress("dimon.sudak2015@gmail.com"));
            message.setSubject("ВНИМАНИЕ: "+ subject);
            message.setText(body);
            Transport.send(message);
            System.out.println("Mail " + subject + " sent to " + toMail);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error mail sending");
            return false;
        }

    }





//    @Autowired
//    private JavaMailSender mailSender;
//
//
//    public boolean sendEmail(String toMail, String subject, String body) {
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom("dimon.sudak2015@gmail.com");
//            message.setTo(toMail);
//            message.setSubject(subject);
//            message.setText(body);
////            mailSender.send(message);
//            return true;
//        } catch (Exception e) {
////            e.printStackTrace();
//            return false;
//        }
//    }

}
