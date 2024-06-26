package dbmodels;
import jakarta.persistence.*;
import java.sql.Timestamp;
//import java.util.Objects;

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

    public Message() {}

    public Message(PrivateChat chat, User sender, String content, Timestamp createdAt) {
        this.chat = chat;
        this.sender = sender;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PrivateChat getChat() {
        return chat;
    }

    public void setChat(PrivateChat chat) {
        this.chat = chat;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Message message = (Message) o;
//        return id == message.id && Objects.equals(chat, message.chat) && Objects.equals(sender, message.sender) && Objects.equals(content, message.content) && Objects.equals(createdAt, message.createdAt);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, chat, sender, content, createdAt);
//    }
}