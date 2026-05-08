package com.jcr.prueba.infraestruture.adapter.postgres.entity;

import com.jcr.prueba.domain.enums.Currency;
import com.jcr.prueba.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private String cardNumber;
    private  String holderName;
    private String cardHolderName;
    private LocalDate issuedAt;
    private LocalDate expiresAt;
    private Status status;
    private LocalDate blockedAt;
    private String blockedReason;
    private Double balance;
    private Currency currency;
}
