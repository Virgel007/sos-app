package org.example.sosbutton.service;

import lombok.extern.slf4j.Slf4j;
import org.example.sosbutton.config.TelegramBotProperties;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@Slf4j
public class TelegramService extends TelegramLongPollingBot {

    private final String botToken;
    private final String chatId;

    public TelegramService(TelegramBotProperties properties) {
        super(properties.getBotToken());
        this.botToken = properties.getBotToken();
        this.chatId = properties.getChatId();
    }

    @Override
    public String getBotUsername() {
        return "YourBotName"; // Замените на имя вашего бота
    }

    @Override
    public void onUpdateReceived(org.telegram.telegrambots.meta.api.objects.Update update) {
        // Обработка входящих сообщений, если нужно
    }

    public void sendMessage(String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            execute(sendMessage);
            log.info("Сообщение успешно отправлено в Telegram: {}", message);
        } catch (TelegramApiException e) {
            log.error("Ошибка при отправке сообщения в Telegram: {}", e.getMessage());
        }
    }
}