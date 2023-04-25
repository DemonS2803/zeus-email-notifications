package ru.prodik.zeus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.prodik.zeus.services.EmailService;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMail() {
        String toMail = "dimon.sudak2015@gmail.com";
        String subject = "Sending mail via Java";
        String body = "message body with edited spring struct";

        boolean sent = emailService.sendEmail(toMail, subject, body);
        if (sent) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



}
