package com.corpchat.CorpChat.dbmodels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}