package org.example.sosbutton.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Telegram контакт не может быть пустым")
    @Size(min = 3, max = 32, message = "Telegram контакт должен содержать от 3 до 32 символов")
    @Column(name = "telegram_contact", nullable = false)
    private String telegramContact; // Контакт Telegram без "@"

    @NotBlank(message = "Код активации не может быть пустым")
    @Size(min = 4, max = 10, message = "Код активации должен содержать от 4 до 6 символов")
    @Column(name = "activation_code", nullable = false)
    private String activationCode; // Код активации

    @NotBlank(message = "Адрес встречи не может быть пустым")
    @Size(min = 3, max = 100, message = "Адрес встречи должен содержать от 3 до 100 символов")
    @Column(name = "meeting_address", nullable = false)
    private String meetingAddress; // Адрес встречи

    @NotBlank(message = "Время свидания не может быть пустым")
    @Size(min = 3, max = 100, message = "Время свидания должно содержать от 3 до 100 символов")
    @Column(name = "meeting_time", nullable = false)
    private String meetingTime; // Время свидания

    @Column(name = "comment")
    private String comment; // Комментарий

    @Column(name = "last_activation_time")
    private LocalDateTime lastActivationTime; // Время последней активации
}
