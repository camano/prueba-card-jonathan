package com.jcr.prueba.application.usecases;

import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.domain.port.CardAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class FindCardIdUseCase {

    private final CardAdapterPort  cardAdapterPort;

    public FindCardIdUseCase(CardAdapterPort cardAdapterPort) {
        this.cardAdapterPort = cardAdapterPort;
    }


    public Card execute(Long cardId) {
        return cardAdapterPort.findByCardId(cardId);
    }
}

