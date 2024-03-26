package org.example.surprise_spring_boot_test.service;

import org.example.surprise_spring_boot_test.dto.FlaskDto;

import java.util.List;

public interface FlaskService {
    List<FlaskDto.UserInfo> sendUserInfosToFlask();
    List<FlaskDto.ExhibitionInfo> sendExhibitionInfosToFlask();
}
