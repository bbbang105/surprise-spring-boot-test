package org.example.surprise_spring_boot_test.controller;

import lombok.RequiredArgsConstructor;
import org.example.surprise_spring_boot_test.dto.FlaskDto;
import org.example.surprise_spring_boot_test.service.FlaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FlaskController {

    private final FlaskService flaskService;

    @GetMapping("/flask/users")
    public List<FlaskDto.UserInfo> sendUserInfosToFlask() {
        return flaskService.sendUserInfosToFlask();
    }

    @GetMapping("/flask/exhibitions")
    public List<FlaskDto.ExhibitionInfo> sendExhibitionInfosToFlask() {
        return flaskService.sendExhibitionInfosToFlask();
    }

    @PostMapping("/flask/recommendations")
    public void receiveRecommendationsFromFlask(@RequestBody List<FlaskDto.RecommendationInfo> recommendationInfos) {
        for (FlaskDto.RecommendationInfo recommendationInfo : recommendationInfos) {
            Long userId = recommendationInfo.getUserId();
            List<FlaskDto.Recommendation> recommendations = recommendationInfo.getRecommendations();

            System.out.println("User ID: " + userId);
            for (FlaskDto.Recommendation recommendation : recommendations) {
                Long exhibitionId = recommendation.getExhibitionId();
                Float weight = recommendation.getWeight();
                System.out.println("- Exhibition ID: " + exhibitionId + " | Weight: " + weight);
            }
        }
    }
}