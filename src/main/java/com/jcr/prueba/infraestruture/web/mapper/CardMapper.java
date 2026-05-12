package com.jcr.prueba.infraestruture.web.mapper;

import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.infraestruture.web.response.CardResponse;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardResponse toResponse(Card card){
        return CardResponse.builder()
                .cardId(card.getCardId())
                .cardNumber(card.getCardNumber())
                .status(card.getStatus())
                .expirationDate(card.getExpiresAt())
                .balance(card.getBalance())
                .currency(card.getCurrency())
                .build();
    }
}
