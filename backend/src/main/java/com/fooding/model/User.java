package com.fooding.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    // 사용자 고유 ID (기본키)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 이름
    private String name;

    // 연락처 (전화번호 등)
    private String phone;

    // 지역 정보 (예: 서울 강남구)
    private String region;

    // 개인 or 사업자 구분
    @Enumerated(EnumType.STRING)
    private UserType type;

    // 회원가입 시간
    private LocalDateTime createdAt;

    // 사용자가 등록한 식재료 목록
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    // 좋아요 받은 기록
    @OneToMany(mappedBy = "toUser")
    private List<Like> likesReceived;

    // 좋아요 한 기록
    @OneToMany(mappedBy = "fromUser")
    private List<Like> likesGiven;

    // 사용자의 위치 정보
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Location location;

    // 거래 기록: 받은 쪽
    @OneToMany(mappedBy = "receiver")
    private List<Match> matchesReceived;

    // 거래 기록: 준 쪽
    @OneToMany(mappedBy = "giver")
    private List<Match> matchesGiven;
}
