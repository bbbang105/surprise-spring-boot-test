package org.example.surprise_spring_boot_test.service;

import lombok.RequiredArgsConstructor;
import org.example.surprise_spring_boot_test.dto.FlaskDto;
import org.example.surprise_spring_boot_test.entity.Exhibition;
import org.example.surprise_spring_boot_test.entity.ExhibitionTag;
import org.example.surprise_spring_boot_test.entity.User;
import org.example.surprise_spring_boot_test.entity.UserTag;
import org.example.surprise_spring_boot_test.repository.ExhibitionRepository;
import org.example.surprise_spring_boot_test.repository.ExhibitionTagRepository;
import org.example.surprise_spring_boot_test.repository.UserRepository;
import org.example.surprise_spring_boot_test.repository.UserTagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlaskServiceImpl implements FlaskService {
    private final UserRepository userRepository;
    private final UserTagRepository userTagRepository;
    private final ExhibitionRepository exhibitionRepository;
    private final ExhibitionTagRepository exhibitionTagRepository;

    @Override
    public List<FlaskDto.UserInfo> sendUserInfosToFlask() {
        List<FlaskDto.UserInfo> userInfos = new ArrayList<>();
        List<User> users = userRepository.findAll();

        for (User user : users) {
            List<UserTag> userTags = userTagRepository.findByUserId(user.getId());
            List<String> tagNames = new ArrayList<>();

            // 사용자의 태그 목록에서 태그 이름을 가져와서 리스트에 추가
            for (UserTag userTag : userTags) {
                String tagName = userTag.getTag().getName();

                if (!tagNames.contains(tagName)) {
                    tagNames.add(tagName);
                }
            }

            // UserInfo DTO에 사용자의 ID와 태그 목록 설정
            FlaskDto.UserInfo userInfo = FlaskDto.UserInfo.builder()
                    .userId(user.getId())
                    .userTagNames(tagNames)
                    .build();

            // 리스트에 UserInfo DTO 추가
            userInfos.add(userInfo);
        }

        return userInfos;
    }

    @Override
    public List<FlaskDto.ExhibitionInfo> sendExhibitionInfosToFlask() {
        List<FlaskDto.ExhibitionInfo> exhibitionInfos = new ArrayList<>();
        List<Exhibition> exhibitions = exhibitionRepository.findAll();

        for (Exhibition exhibition : exhibitions) {
            List<ExhibitionTag> exhibitionTags = exhibitionTagRepository.findByExhibitionId(exhibition.getId());
            List<String> tagNames = new ArrayList<>();

            // 전시회의 태그 목록에서 태그 이름을 가져와서 리스트에 추가
            for (ExhibitionTag exhibitionTag : exhibitionTags) {
                String exhibitionName = exhibitionTag.getTag().getName();

                if (!tagNames.contains(exhibitionName)) {
                    tagNames.add(exhibitionName);
                }
            }

            // ExhibitionInfo DTO에 전시회의 ID와 태그 목록 설정
            FlaskDto.ExhibitionInfo exhibitionInfo = FlaskDto.ExhibitionInfo.builder()
                    .exhibitionId(exhibition.getId())
                    .exhibitionTagNames(tagNames)
                    .build();

            // 리스트에 ExhibitionInfo DTO 추가
            exhibitionInfos.add(exhibitionInfo);
        }

        return exhibitionInfos;
    }
}