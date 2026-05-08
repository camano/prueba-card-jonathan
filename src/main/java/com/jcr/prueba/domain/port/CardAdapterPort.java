package com.jcr.prueba.domain.port;

import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.infraestruture.web.response.CardResponse;
import com.jcr.prueba.infraestruture.web.request.CardRequest;

public interface CardAdapterPort {

    CardResponse generateCard(CardRequest cardRequest);

    Card activeCard(Card card);

    Card blockedCard(Card card);

    Card findByCardId(Long cardId);
}
