package org.example.surprise_spring_boot_test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "exhibition")
public class Exhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibition_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "exhibition_fk_user_id"))
    private User user;

    @Column(name = "exhibition_uuid")
    private UUID exhibitionId;

    @Column(name = "exhibition_thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "exhibition_title", length = 50)
    private String title;

    @Column(name = "exhibition_description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "exhibition_view_count")
    private Long viewCount;

    @Column(name = "exhibition_created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "exhibition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExhibitionTag> exhibitionTags;
}