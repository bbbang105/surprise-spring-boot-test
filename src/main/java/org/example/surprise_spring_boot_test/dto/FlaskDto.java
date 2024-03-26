package org.example.surprise_spring_boot_test.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

public class FlaskDto {

    @Data
    @Builder
    public static class UserInfo {
        private final Long userId;
        private final List<String> userTagNames;
    }

    @Data
    @Builder
    public static class ExhibitionInfo {
        private final Long exhibitionId;
        private final List<String> exhibitionTagNames;
    }

    @Data
    @Builder
    public static class RecommendationInfo {
        private final Long userId;
        private final List<Recommendation> recommendations;
    }

    @Data
    @Builder
    public static class Recommendation {
        private final Long exhibitionId;
        private final Float weight;
    }

}