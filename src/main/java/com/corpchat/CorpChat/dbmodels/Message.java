package com.corpchat.CorpChat.dbmodels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

/**
 * Implements the Message.
 * The `messages` table stores information about messages in private chats.
 * Structure:
 *      `id`: The unique identifier of the message (Primary Key).
 *      `chat_id`: Personal chat ID (Foreign Key, refers to `private_chat.id`).
 *      `sender_id`: The ID of the user who sent the message (The Foreign Key refers to `users.id`).
 *      `content`: The content of the message.
 *      `created_at`: Date and time the message was created.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private PrivateChat chat;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", chat=" + chat +
                ", sender=" + sender +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}