package org.example.surprise_spring_boot_test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_uuid")
    private UUID userId;

    @Column(name = "user_provider", nullable = true, length = 50)
    private String provider;

    @Column(name = "user_nickname", length = 50)
    private String nickname;

    @Column(name = "user_email", length = 50)
    private String email;

    @Column(name = "user_role", length = 20)
    private String role;

    @Column(name = "user_introduce", nullable = true, length = 20)
    private String introduce;

    @Column(name = "user_biography", nullable = true, columnDefinition = "TEXT")
    private String biography;

    @Column(name = "user_created_at")
    private LocalDateTime createdAt;

    @Column(name = "user_updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @Column(name = "user_view_count")
    private Long viewCount;

    @Column(name = "user_support_count")
    private Long supportCount;
}
