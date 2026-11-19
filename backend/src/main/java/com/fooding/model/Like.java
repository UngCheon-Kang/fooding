package com.fooding.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Like {

    // 좋아요 고유 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 좋아요 누른 사람
    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    // 좋아요 받은 사람
    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    // 좋아요 누른 시간
    private LocalDateTime createdAt;
}
