package com.fooding.controller;

import com.fooding.model.Ingredient;
import com.fooding.model.IngredientMode;
import com.fooding.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000") // React 연결 허용
@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    // 전체 재료 조회
    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

    // 특정 사용자 재료 조회
    @GetMapping("/user/{userId}")
    public List<Ingredient> getIngredientsByUser(@PathVariable Long userId) {
        return ingredientService.findByUser(userId);
    }

    // 모드별 조회 (GIVE / TAKE)
    @GetMapping("/mode/{mode}")
    public List<Ingredient> getByMode(@PathVariable IngredientMode mode) {
        return ingredientService.findByMode(mode);
    }

    // 재료 등록
    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }

    // 재료 삭제
    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.delete(id);
    }
}
