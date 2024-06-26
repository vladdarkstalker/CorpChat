package dbmodels;
import jakarta.persistence.*;
import java.sql.Timestamp;
//import java.util.Objects;

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

    public PostLike() {}

    public PostLike(Post post, User user, String likeType, Timestamp createdAt) {
        this.post = post;
        this.user = user;
        this.likeType = likeType;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLikeType() {
        return likeType;
    }

    public void setLikeType(String likeType) {
        this.likeType = likeType;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PostLike postLike = (PostLike) o;
//        return id == postLike.id && Objects.equals(post, postLike.post) && Objects.equals(user, postLike.user) && Objects.equals(likeType, postLike.likeType) && Objects.equals(createdAt, postLike.createdAt);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, post, user, likeType, createdAt);
//    }
}
