package ru.prodik.zeus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.prodik.zeus.entities.Message;
import ru.prodik.zeus.enums.Status;
import ru.prodik.zeus.repositories.MessageRepository;

import java.util.ArrayList;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private EmailService emailService;


//    public Long countAll() {
//        return messageRepository.countAll();
//    }

    public ArrayList<Message> getAll() {
        return messageRepository.findAll();
    }

//    public ArrayList<Message> getAllNewByChatId(Long chatId) {
//        return messageRepository.findMessagesByChatIdAndStatus(chatId, Status.CREATED);
//    }

//    public ArrayList<Message>

    public boolean setMessageStatusSent(Long messageId) {
        var msg = messageRepository.findMessageById(messageId);
        msg.setStatus(Status.SENT);
        messageRepository.save(msg);
        return true;
    }

    public ArrayList<Message> getNewMessages() {
        return messageRepository.findMessagesByStatus(Status.CREATED);
    }

    @Scheduled(fixedRate = 5000)
    public void sendNewMessages() {
        System.out.println("Sending notifications to subscriber");
        // set recipient email
        String toMail = "dmtr.sudakov@rambler.ru";
        var messages = getNewMessages();
        for (Message message : messages) {
            emailService.sendEmail(toMail, message.getTitle(), message.getMessage());
            setMessageStatusSent(message.getId());
        }
    }
}
