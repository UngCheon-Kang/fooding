package com.fooding.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    // 사용자 ID (1:1 관계)
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    // 위도
    private double latitude;

    // 경도
    private double longitude;
}
