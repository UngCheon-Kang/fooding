package com.fooding.repository;

import com.fooding.model.Ingredient;
import com.fooding.model.IngredientMode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 식재료 정보를 조회/저장하는 인터페이스
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    // 특정 사용자(ID)의 재료 목록 가져오기
    List<Ingredient> findByUserId(Long userId);

    // 받기 or 주기 모드에 따라 검색
    List<Ingredient> findByMode(IngredientMode mode);

}
