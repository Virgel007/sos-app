package org.example.sosbutton.service;

import org.example.sosbutton.model.UserProfile;

public interface UserProfileService {
    void updateUserProfile(UserProfile profile);

    UserProfile getUserProfile(Long userId);
}
