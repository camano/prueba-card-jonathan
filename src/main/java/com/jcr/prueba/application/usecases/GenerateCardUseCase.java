package com.jcr.prueba.application.usecases;

import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.infraestruture.web.response.CardResponse;
import com.jcr.prueba.domain.port.CardAdapterPort;
import com.jcr.prueba.infraestruture.web.request.CardRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenerateCardUseCase {

    private final CardAdapterPort cardAdapterPort;

    public GenerateCardUseCase(CardAdapterPort cardAdapterPort) {
        this.cardAdapterPort = cardAdapterPort;
    }


    public Card generateCard(CardRequest cardRequest) {

        return cardAdapterPort.generateCard(cardRequest);

    }
}
