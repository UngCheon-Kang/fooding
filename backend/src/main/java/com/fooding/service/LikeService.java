package com.fooding.service;

import com.fooding.model.Like;
import com.fooding.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository likeRepo;

    public LikeService(LikeRepository likeRepo) {
        this.likeRepo = likeRepo;
    }

    // 좋아요 저장
    public Like save(Like like) {
        return likeRepo.save(like);
    }

    // 전체 좋아요 목록 조회 (관리용)
    public List<Like> findAll() {
        return likeRepo.findAll();
    }

    // 좋아요 삭제
    public void delete(Long id) {
        likeRepo.deleteById(id);
    }
}
