package org.example.sosbutton.config;

import lombok.RequiredArgsConstructor;
import org.example.sosbutton.service.TelegramService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TelegramBotInitializer implements CommandLineRunner {

    private final TelegramService telegramService;

    public TelegramBotInitializer(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Telegram бот успешно запущен!");
    }
}