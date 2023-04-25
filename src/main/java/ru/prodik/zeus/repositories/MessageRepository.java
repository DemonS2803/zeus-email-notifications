package ru.prodik.zeus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.prodik.zeus.entities.Message;
import ru.prodik.zeus.enums.Status;

import java.util.ArrayList;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

//    Long countAll();
    ArrayList<Message> findAll();
    Message findMessageById(Long messageId);

    ArrayList<Message> findMessagesByStatus(Status status);

}
