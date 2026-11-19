package com.fooding.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    // 거래 고유 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 재료 제공자 (giver)
    @ManyToOne
    @JoinColumn(name = "giver_id")
    private User giver;

    // 재료 받는 사람 (receiver)
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    // 거래된 식재료
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    // 거래 유형: 나눔 or 교환
    @Enumerated(EnumType.STRING)
    private MatchType type;

    // 거래 일시
    private LocalDateTime createdAt;
}
