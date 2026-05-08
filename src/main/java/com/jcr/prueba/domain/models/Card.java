package com.jcr.prueba.domain.models;

import com.jcr.prueba.domain.enums.Currency;
import com.jcr.prueba.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {

    private Long cardId;
    private String cardNumber;
    private String holderName;
    private Status status;
    private LocalDate blockedAt;
    private String bloqueReason;
    private LocalDate expiresAt;
    private Double balance;
    private Currency currency;

}
