package com.corpchat.CorpChat.dbmodels;
import jakarta.persistence.*;
import java.sql.Timestamp;
//import java.util.Objects;

/**
 * Implements the Post model.
 * The `posts` table stores information about posts in channels.
 * Structure:
 *      `id`: The unique identifier of the post (Primary Key).
 *      `channel_id`: ID of the channel where the post is posted (Foreign Key, refers to `channels.id`).
 *      `user_id`: The ID of the user who created the post (The Foreign Key refers to `users.id`).
 *      `content`: The content of the post.
 *      `created_at`: Date and time the post was created
 */

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    public Post() {}

    public Post(Channel channel, User user, String content, Timestamp createdAt) {
        this.channel = channel;
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Post{" +
                "id=" + id +
                ", channel=" + channel +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Post post = (Post) o;
//        return id == post.id && Objects.equals(channel, post.channel) && Objects.equals(user, post.user) && Objects.equals(content, post.content) && Objects.equals(createdAt, post.createdAt);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, channel, user, content, createdAt);
//    }
}