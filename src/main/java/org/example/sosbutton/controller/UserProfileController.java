package org.example.sosbutton.controller;

import lombok.RequiredArgsConstructor;
import org.example.sosbutton.model.UserProfile;
import org.example.sosbutton.service.UserProfileService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profile")
@Validated
public class UserProfileController {

    private final UserProfileService userProfileService;


    // Создание/обновление анкеты
    @PostMapping("/update")
    public String updateProfile(@RequestBody UserProfile profile) {
        userProfileService.updateUserProfile(profile);
        return "Анкета обновлена!";
    }

    // Получение данных анкеты по ID пользователя
    @GetMapping("/{userId}")
    public UserProfile getProfile(@PathVariable Long userId) {
        return userProfileService.getUserProfile(userId);
    }
}