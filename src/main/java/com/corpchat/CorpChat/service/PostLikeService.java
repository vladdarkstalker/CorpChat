package com.corpchat.CorpChat.service;

import com.corpchat.CorpChat.dbmodels.PostLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corpchat.CorpChat.repository.PostLikeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostLikeService {

    @Autowired
    private PostLikeRepository postLikeRepository;

    public List<PostLike> getAllPostLikes() {
        return postLikeRepository.findAll();
    }

    public Optional<PostLike> getPostLikeById(Integer id) {
        return postLikeRepository.findById(id);
    }

    public List<PostLike> getPostLikesByPostId(Integer postId) {
        return postLikeRepository.findByPostId(postId);
    }

    public List<PostLike> getPostLikesByUserId(Integer userId) {
        return postLikeRepository.findByUserId(userId);
    }

    public List<PostLike> getPostLikesByLikeType(String likeType) {
        return postLikeRepository.findByLikeType(likeType);
    }

    public PostLike createPostLike(PostLike postLike) {
        return postLikeRepository.save(postLike);
    }

    public void deletePostLike(Integer id) {
        postLikeRepository.deleteById(id);
    }
}