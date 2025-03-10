package org.example.sosbutton.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "sos_button")
public class SOSButton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false; // Состояние кнопки (по умолчанию неактивна)

    @Column(name = "activation_time")
    private LocalDateTime activationTime; // Время активации

    @Column(name = "deactivation_code")
    private String deactivationCode; // Код деактивации
}