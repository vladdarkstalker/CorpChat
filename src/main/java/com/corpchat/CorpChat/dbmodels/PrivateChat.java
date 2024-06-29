package com.corpchat.CorpChat.dbmodels;
import jakarta.persistence.*;
import java.sql.Timestamp;
//import java.util.Objects;

/**
 * Implements the PrivateChat model.
 * The `private_cheats` table stores information about private chats between users.
 * Structure:
 *      `id`: The unique identifier of the personal chat (Primary Key).
 *      `sender_id`: The ID of the user who sent the message (The Foreign Key refers to `users.id`).
 *      `receiver_id`: The ID of the user who received the message (The Foreign Key refers to `users.id`).
 *      `created_at`: Date and time the chat was created
 */

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

    public PrivateChat() {}

    public PrivateChat(User sender, User receiver, Timestamp createdAt) {
        this.sender = sender;
        this.receiver = receiver;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PrivateChat that = (PrivateChat) o;
//        return id == that.id && Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver) && Objects.equals(createdAt, that.createdAt);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, sender, receiver, createdAt);
//    }
}
