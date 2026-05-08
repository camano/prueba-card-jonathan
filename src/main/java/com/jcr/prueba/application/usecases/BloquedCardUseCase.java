package com.jcr.prueba.application.usecases;

import com.jcr.prueba.domain.enums.Status;
import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.domain.port.CardAdapterPort;
import com.jcr.prueba.infraestruture.helper.excepcion.BusinessExcepction;
import com.jcr.prueba.infraestruture.web.request.CardBlockRequest;
import com.jcr.prueba.infraestruture.web.response.CardActiveResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BloquedCardUseCase {

    private final CardAdapterPort cardAdapterPort;

    public BloquedCardUseCase(CardAdapterPort cardAdapterPort) {
        this.cardAdapterPort = cardAdapterPort;
    }

    public CardActiveResponse execute(Long cardId, CardBlockRequest cardBlockRequest) {

        Card card = cardAdapterPort.findByCardId(cardId);

        if(card.getStatus() == Status.ACTIVE) {
            card.setStatus(Status.BLOQUED);
            card.setBlockedAt(LocalDate.now());
            card.setBloqueReason(cardBlockRequest.reason());

            Card cardActive = cardAdapterPort.blockedCard(card);

            return  CardActiveResponse.builder()
                    .cardId(cardActive.getCardId())
                    .status(cardActive.getStatus())
                    .build();
        }else {
            throw new BusinessExcepction("la tarjeta tiene que estar activa");
        }


    }
}
