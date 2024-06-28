package repository;

import dbmodels.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByChannelId(Integer channelId);
    List<Post> findByUserId(Integer userId);
    List<Post> findByContentContaining(String content);
}
