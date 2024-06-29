package controller;

import dbmodels.PostLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.PostLikeService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/post-likes")
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    @GetMapping
    public List<PostLike> getAllPostLikes() {
        return postLikeService.getAllPostLikes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostLike> getPostLikeById(@PathVariable Integer id) {
        Optional<PostLike> postLike = postLikeService.getPostLikeById(id);
        if (postLike.isPresent()) {
            return ResponseEntity.ok(postLike.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/post/{postId}")
    public List<PostLike> getPostLikesByPostId(@PathVariable Integer postId) {
        return postLikeService.getPostLikesByPostId(postId);
    }

    @GetMapping("/user/{userId}")
    public List<PostLike> getPostLikesByUserId(@PathVariable Integer userId) {
        return postLikeService.getPostLikesByUserId(userId);
    }

    @GetMapping("/type/{likeType}")
    public List<PostLike> getPostLikesByLikeType(@PathVariable String likeType) {
        return postLikeService.getPostLikesByLikeType(likeType);
    }

    @PostMapping
    public ResponseEntity<PostLike> createPostLike(@RequestBody PostLike postLike) {
        PostLike createdPostLike = postLikeService.createPostLike(postLike);
        return ResponseEntity.ok(createdPostLike);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostLike(@PathVariable Integer id) {
        postLikeService.deletePostLike(id);
        return ResponseEntity.noContent().build();
    }
}
