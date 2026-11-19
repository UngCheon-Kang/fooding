package com.fooding.repository;

import com.fooding.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

// 좋아요 관련 작업을 처리하는 인터페이스
public interface LikeRepository extends JpaRepository<Like, Long> {

}
