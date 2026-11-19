package com.fooding.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {

    // 식재료 고유 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 등록한 사용자 (외래키)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 식재료 이름
    private String name;

    // 무게 (예: 500g, 3kg)
    private String weight;

    // 유통기한
    private LocalDate expiryDate;

    // 재료 등록 목적 (주기 or 받기)
    @Enumerated(EnumType.STRING)
    private IngredientMode mode;

    // 거래 완료 여부
    private boolean isShared;

    // 등록 시각
    private LocalDateTime createdAt;
}
