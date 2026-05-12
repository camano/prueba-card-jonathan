package com.jcr.prueba.infraestruture.adapter.postgres.mapper;

import com.jcr.prueba.domain.enums.Currency;
import com.jcr.prueba.domain.enums.Status;
import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.infraestruture.adapter.postgres.entity.CardEntity;
import com.jcr.prueba.infraestruture.web.request.CardRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class CardMapperEntity {



    public CardEntity toEntityCardEntityCreated(CardRequest card) {

        return CardEntity.builder()
                .holderName(card.holderName())
                .cardNumber(generateCardNumber(card.productId()))
                .expiresAt(LocalDate.now().plusYears(3))
                .issuedAt(LocalDate.now())
                .status(Status.ISSUED)
                .balance(0.0)
                .currency(Currency.USD)
                .build();
    }


    public CardEntity toEntityCardEntity(Card card) {

        return CardEntity.builder()
                .cardId(card.getCardId())
                .holderName(card.getHolderName())
                .cardNumber(card.getCardNumber())
                .expiresAt(card.getExpiresAt())
                .status(card.getStatus())
                .balance(0.0)
                .currency(card.getCurrency())
                .blockedAt(card.getBlockedAt())
                .blockedReason(card.getBloqueReason())
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

    private String generateCardNumber(String cardId) {
        String random=String.format("%10d", new Random().nextLong(1_000_000_0000L));
        return random + cardId;

    }
}
