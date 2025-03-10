-- Создание таблицы для профиля пользователя
CREATE TABLE user_profile (
                              id SERIAL PRIMARY KEY,
                              telegram_contact VARCHAR(255) NOT NULL,
                              activation_code VARCHAR(255) NOT NULL,
                              meeting_address TEXT NOT NULL,
                              meeting_time VARCHAR(255) NOT NULL,
                              comment TEXT,
                              last_activation_time TIMESTAMP
);

-- Создание таблицы для кнопки SOS
CREATE TABLE sos_button (
                            id SERIAL PRIMARY KEY,
                            is_active BOOLEAN DEFAULT FALSE,
                            activation_time TIMESTAMP,
                            deactivation_code VARCHAR(255)
);