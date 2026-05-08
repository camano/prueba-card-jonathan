package com.jcr.prueba.application.usecases;

import com.jcr.prueba.domain.enums.Status;
import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.domain.port.CardAdapterPort;
import com.jcr.prueba.infraestruture.adapter.postgres.repository.CardRepository;
import com.jcr.prueba.infraestruture.helper.excepcion.BusinessExcepction;
import com.jcr.prueba.infraestruture.web.response.CardActiveResponse;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class activeCardUseCase {

    private final CardAdapterPort cardAdapterPort;

    public activeCardUseCase(CardAdapterPort cardAdapterPort) {
        this.cardAdapterPort = cardAdapterPort;
    }


    public CardActiveResponse execute(Long cardId) {

        Card card = cardAdapterPort.findByCardId(cardId);

        if(card.getStatus() == Status.ISSUED) {
            card.setStatus(Status.ACTIVE);

            Card cardActive = cardAdapterPort.activeCard(card);

            return  CardActiveResponse.builder()
                    .cardId(cardActive.getCardId())
                    .status(cardActive.getStatus())
                    .build();
        }else {
            throw new BusinessExcepction("la tarjeta tiene que estar activa");
        }


    }



}
