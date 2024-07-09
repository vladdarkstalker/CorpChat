package com.corpchat.CorpChat.dbmodels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

/**
 * Implements the PostLike model.
 * The `post_likes` table stores information about likes and dislikes of posts.
 * Structure:
 *      `id`: The unique identifier of the like/dislike record (Primary Key).
 *      `post_id`: The ID of the post (Foreign Key, refers to `posts.id`).
 *      `user_id`: The ID of the user who liked/disliked (Foreign Key, refers to `users.id`).
 *      `like_type`: The type of reaction (`like` or `dislike`).
 *      `created_at`: Date and time when the like/dislike was created.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post_likes")
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "like_type", nullable = false)
    private String likeType;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Override
    public String toString() {
        return "PostLike{" +
                "id=" + id +
                ", post=" + post +
                ", user=" + user +
                ", likeType='" + likeType + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
