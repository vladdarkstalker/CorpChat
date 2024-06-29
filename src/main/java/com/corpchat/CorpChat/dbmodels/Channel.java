package com.corpchat.CorpChat.dbmodels;
import jakarta.persistence.*;
import java.sql.Timestamp;
//import java.util.Objects;

/**
 * Implements the Channel model.
 * The `channels` table stores information about channels.
 * Structure:
 *      `id`: Unique channel identifier (Primary Key).
 *      `name`: The unique name of the channel.
 *      `description`: Description of the channel.
 *      `created_at`: The date and time the channel was created.
 *      `created_by`: ID of the user who created the channel (Foreign Key refers to `users.id`).
 */

@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    public Channel() {}

    public Channel(String name, String description, Timestamp createdAt, User createdBy) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Channel channel = (Channel) o;
//        return id == channel.id && Objects.equals(name, channel.name) && Objects.equals(description, channel.description) && Objects.equals(createdAt, channel.createdAt) && Objects.equals(createdBy, channel.createdBy);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, description, createdAt, createdBy);
//    }
}
