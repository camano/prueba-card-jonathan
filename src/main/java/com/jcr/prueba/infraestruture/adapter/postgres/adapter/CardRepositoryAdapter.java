package com.jcr.prueba.infraestruture.adapter.postgres.adapter;

import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.infraestruture.helper.excepcion.BusinessExcepction;
import com.jcr.prueba.infraestruture.web.response.CardResponse;
import com.jcr.prueba.domain.port.CardAdapterPort;
import com.jcr.prueba.infraestruture.adapter.postgres.mapper.CardMapper;
import com.jcr.prueba.infraestruture.adapter.postgres.repository.CardRepository;
import com.jcr.prueba.infraestruture.web.request.CardRequest;
import com.jcr.prueba.infraestruture.web.response.CardActiveResponse;
import org.springframework.stereotype.Component;

@Component
public class CardRepositoryAdapter implements CardAdapterPort {

    private final CardRepository cardRepository;

    private final CardMapper cardMapper;

    public CardRepositoryAdapter(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public CardResponse generateCard(CardRequest cardRequest) {
        return cardMapper.toDomainCard(cardRepository.save(cardMapper.toEntityCardEntityCreated(cardRequest)));
    }

    @Override
    public Card activeCard(Card card) {
        return cardMapper.toDomainCards(cardRepository.save(cardMapper.toEntityCardEntityActive(card)));
    }

    @Override
    public Card blockedCard(Card card) {
        return cardMapper.toDomainCards(cardRepository.save(cardMapper.toEntityCardEntityBlock(card)));
    }


    @Override
    public Card findByCardId(Long cardId) {
        return cardRepository.findById(cardId)
                .map(cardMapper::toDomainCards)
                .orElseThrow(() -> new BusinessExcepction("no se encontro la tarjeta"));
    }
}
