package com.jcr.prueba.infraestruture.adapter.postgres.mapper;

import com.jcr.prueba.domain.enums.Currency;
import com.jcr.prueba.domain.enums.Status;
import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.infraestruture.web.response.CardResponse;
import com.jcr.prueba.infraestruture.adapter.postgres.entity.CardEntity;
import com.jcr.prueba.infraestruture.web.request.CardRequest;
import com.jcr.prueba.infraestruture.web.response.CardActiveResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CardMapper {


    public CardResponse toDomainCard(CardEntity cardEntity) {
        return CardResponse.builder()
                .cardId(cardEntity.getCardId())
                .cardNumber(cardEntity.getCardNumber())
                .status(cardEntity.getStatus())
                .expirationDate(cardEntity.getExpiresAt())
                .balance(cardEntity.getBalance())
                .currency(cardEntity.getCurrency())
                .build();

    }

    public CardEntity toEntityCardEntityCreated(CardRequest card) {

        return CardEntity.builder()
                .holderName(card.holderName())
                .cardNumber(card.productId())
                .expiresAt(LocalDate.now().plusYears(3))
                .status(Status.ISSUED)
                .balance(0.0)
                .currency(Currency.USD)

                .build();
    }


    public CardEntity toEntityCardEntityActive(Card card) {

        return CardEntity.builder()
                .cardId(card.getCardId())
                .holderName(card.getHolderName())
                .cardNumber(card.getCardNumber())
                .expiresAt(LocalDate.now().plusYears(3))
                .status(card.getStatus())
                .balance(0.0)
                .currency(Currency.USD)
                .build();
    }

    public Card toDomainCards(CardEntity cardEntity){
        return Card.builder()
                .cardId(cardEntity.getCardId())
                .cardNumber(cardEntity.getCardNumber())
                .holderName(cardEntity.getHolderName())
                .status(cardEntity.getStatus())
                .blockedAt(cardEntity.getBlockedAt())
                .bloqueReason(cardEntity.getBlockedReason())
                .expiresAt(cardEntity.getExpiresAt())
                .balance(cardEntity.getBalance())
                .currency(cardEntity.getCurrency())
                .build();
    }
}
