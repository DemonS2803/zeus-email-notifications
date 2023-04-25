package ru.prodik.zeus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.prodik.zeus.enums.Status;

import java.io.Serial;

@Entity
@Data
@Builder
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    private Long id;
    private String message;
    private String title;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
