package org.example.sosbutton.service;

public interface SOSButtonService {
    void activateButton(Long userId, String deactivationCode);

    void deactivateButton(Long userId, String enteredCode);

    boolean isButtonActive(Long userId);
}
