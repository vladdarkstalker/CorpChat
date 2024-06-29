package com.corpchat.CorpChat.repository;

import com.corpchat.CorpChat.dbmodels.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostLikeRepository extends JpaRepository<PostLike, Integer> {
    List<PostLike> findByPostId(Integer postId);
    List<PostLike> findByUserId(Integer userId);
    List<PostLike> findByLikeType(String likeType);
}