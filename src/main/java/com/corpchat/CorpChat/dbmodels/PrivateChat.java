package com.corpchat.CorpChat.dbmodels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

/**
 * Implements the PrivateChat model.
 * The `private_cheats` table stores information about private chats between users.
 * Structure:
 *      `id`: The unique identifier of the personal chat (Primary Key).
 *      `sender_id`: The ID of the user who sent the message (The Foreign Key refers to `users.id`).
 *      `receiver_id`: The ID of the user who received the message (The Foreign Key refers to `users.id`).
 *      `created_at`: Date and time the chat was created
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "private_chats")
public class PrivateChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    public PrivateChat(User sender, User receiver, Timestamp createdAt) {
        this.sender = sender;
        this.receiver = receiver;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PrivateChat{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", createdAt=" + createdAt +
                '}';
    }
}
