package org.example.sosbutton.controller;

import lombok.RequiredArgsConstructor;
import org.example.sosbutton.service.SOSButtonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sos")
public class SOSButtonController {

    private final SOSButtonService sosButtonService;


    // Активация кнопки SOS
    @PostMapping("/activate")
    public String activateButton(@RequestParam Long userId, @RequestParam String deactivationCode) {
        sosButtonService.activateButton(userId, deactivationCode);
        return "Кнопка активирована!";
    }

    // Деактивация кнопки SOS
    @PostMapping("/deactivate")
    public String deactivateButton(@RequestParam Long userId, @RequestParam String enteredCode) {
        sosButtonService.deactivateButton(userId, enteredCode);
        return "Кнопка деактивирована!";
    }

    // Проверка состояния кнопки SOS
    @GetMapping("/status/{userId}")
    public boolean getButtonStatus(@PathVariable Long userId) {
        return sosButtonService.isButtonActive(userId);
    }
}