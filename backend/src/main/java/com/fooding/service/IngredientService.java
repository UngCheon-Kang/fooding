package com.fooding.service;

import com.fooding.model.Ingredient;
import com.fooding.model.IngredientMode;
import com.fooding.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepo;

    // 생성자를 통해 Repository 주입
    public IngredientService(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    // 새로운 식재료 등록
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    // 전체 식재료 목록 조회
    public List<Ingredient> findAll() {
        return ingredientRepo.findAll();
    }

    // 특정 사용자(userId)의 식재료 목록 조회
    public List<Ingredient> findByUser(Long userId) {
        return ingredientRepo.findByUserId(userId);
    }

    // '주기' or '받기' 모드로 재료 검색
    public List<Ingredient> findByMode(IngredientMode mode) {
        return ingredientRepo.findByMode(mode);
    }

    // ID로 특정 재료 조회 (Optional)
    public Optional<Ingredient> findById(Long id) {
        return ingredientRepo.findById(id);
    }

    // 재료 삭제
    public void delete(Long id) {
        ingredientRepo.deleteById(id);
    }
}
