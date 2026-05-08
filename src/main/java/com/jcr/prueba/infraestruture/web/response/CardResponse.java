package com.jcr.prueba.infraestruture.web.response;

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
public class CardResponse {

    private Long cardId;
    private String cardNumber;
    private Status status;
    private LocalDate expirationDate;
    private Double balance;
    private Currency currency;
}
