package com.fooding.controller;

import com.fooding.model.Like;
import com.fooding.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    // 좋아요 등록
    @PostMapping
    public Like createLike(@RequestBody Like like) {
        return likeService.save(like);
    }

    // 전체 좋아요 조회 (관리용)
    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.findAll();
    }

    // 좋아요 삭제
    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id) {
        likeService.delete(id);
    }
}
