package com.jcr.prueba.infraestruture.adapter.postgres.adapter;

import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.infraestruture.helper.excepcion.BusinessExcepction;
import com.jcr.prueba.domain.port.CardAdapterPort;
import com.jcr.prueba.infraestruture.adapter.postgres.mapper.CardMapperEntity;
import com.jcr.prueba.infraestruture.adapter.postgres.repository.CardRepository;
import com.jcr.prueba.infraestruture.web.request.CardRequest;
import org.springframework.stereotype.Component;

@Component
public class CardRepositoryAdapter implements CardAdapterPort {

    private final CardRepository cardRepository;

    private final CardMapperEntity cardMapperEntity;

    public CardRepositoryAdapter(CardRepository cardRepository, CardMapperEntity cardMapperEntity) {
        this.cardRepository = cardRepository;
        this.cardMapperEntity = cardMapperEntity;
    }

    @Override
    public Card generateCard(CardRequest cardRequest) {
        return cardMapperEntity.toDomainCards(cardRepository.save(cardMapperEntity.toEntityCardEntityCreated(cardRequest)));
    }

    @Override
    public Card activeCard(Card card) {
        return cardMapperEntity.toDomainCards(cardRepository.save(cardMapperEntity.toEntityCardEntity(card)));
    }

    @Override
    public Card blockedCard(Card card) {
        return cardMapperEntity.toDomainCards(cardRepository.save(cardMapperEntity.toEntityCardEntity(card)));
    }


    @Override
    public Card findByCardId(Long cardId) {
        return cardRepository.findById(cardId)
                .map(cardMapperEntity::toDomainCards)
                .orElseThrow(() -> new BusinessExcepction("no se encontro la tarjeta"));
    }
}
