package org.example.sosbutton.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.sosbutton.model.SOSButton;
import org.example.sosbutton.model.UserProfile;
import org.example.sosbutton.repository.SOSButtonRepository;
import org.example.sosbutton.repository.UserProfileRepository;
import org.example.sosbutton.service.SOSButtonService;
import org.example.sosbutton.service.TelegramService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SOSButtonServiceImpl implements SOSButtonService {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final SOSButtonRepository sosButtonRepository;
    private final TelegramService telegramService;
    private final UserProfileRepository userProfileRepository;


    // Активация кнопки
    public void activateButton(Long userId, String deactivationCode) {
        SOSButton button = new SOSButton();
        button.setIsActive(true);
        button.setActivationTime(LocalDateTime.now());
        button.setDeactivationCode(deactivationCode);

        sosButtonRepository.save(button);

        // Запуск таймера на 60 секунд
        scheduler.schedule(() -> {
            sendSOSData(userId);
        }, 60, TimeUnit.SECONDS);
    }

    // Деактивация кнопки
    public void deactivateButton(Long userId, String enteredCode) {
        SOSButton button = sosButtonRepository.findById(userId).orElse(null);
        if (button == null || !button.getDeactivationCode().equals(enteredCode)) {
            throw new IllegalArgumentException("Неправильный код деактивации.");
        }

        button.setIsActive(false);
        sosButtonRepository.save(button);
    }

    // Проверка состояния кнопки
    public boolean isButtonActive(Long userId) {
        SOSButton button = sosButtonRepository.findById(userId).orElse(null);
        return button != null && button.getIsActive();
    }

    // Отправка данных в Telegram
    private void sendSOSData(Long userId) {
        UserProfile profile = userProfileRepository.findById(userId).orElse(null);
        if (profile == null) {
            System.out.println("Ошибка: Пользователь не найден.");
            return;
        }

        // Формируем сообщение
        String message = "🚨 SOS СИГНАЛ 🚨\n" +
                "ID пользователя: " + userId + "\n" +
                "Telegram контакт: " + profile.getTelegramContact() + "\n" +
                "Адрес встречи: " + profile.getMeetingAddress() + "\n" +
                "Время свидания: " + profile.getMeetingTime() + "\n" +
                "Комментарий: " + profile.getComment();

        // Отправляем сообщение через Telegram
        telegramService.sendMessage(message);

        System.out.println("SOS данные отправлены для пользователя ID: " + userId);
    }
}
