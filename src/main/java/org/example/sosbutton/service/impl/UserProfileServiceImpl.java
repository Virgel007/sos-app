package org.example.sosbutton.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.sosbutton.model.UserProfile;
import org.example.sosbutton.repository.UserProfileRepository;
import org.example.sosbutton.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    // Обновление анкеты
    public void updateUserProfile(UserProfile profile) {
        userProfileRepository.save(profile);
    }

    // Получение анкеты по ID пользователя
    public UserProfile getUserProfile(Long userId) {
        return userProfileRepository.findById(userId).orElse(null);
    }
}