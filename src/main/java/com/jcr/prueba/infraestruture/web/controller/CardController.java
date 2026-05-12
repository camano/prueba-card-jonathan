package com.jcr.prueba.infraestruture.web.controller;

import com.jcr.prueba.application.usecases.BloquedCardUseCase;
import com.jcr.prueba.application.usecases.FindCardIdUseCase;
import com.jcr.prueba.application.usecases.GenerateCardUseCase;
import com.jcr.prueba.application.usecases.activeCardUseCase;
import com.jcr.prueba.domain.models.Card;
import com.jcr.prueba.infraestruture.web.mapper.CardMapper;
import com.jcr.prueba.infraestruture.web.request.CardBlockRequest;
import com.jcr.prueba.infraestruture.web.response.CardActiveResponse;
import com.jcr.prueba.infraestruture.web.response.CardResponse;
import com.jcr.prueba.infraestruture.web.request.CardRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cards")
public class CardController {

    private final CardMapper  cardMapper;
    private final GenerateCardUseCase generateCardUseCase;
    private final FindCardIdUseCase cardIdUseCase;
    private final activeCardUseCase activeCardUseCase;
    private  final BloquedCardUseCase bloquedCardUseCase;
    public CardController(CardMapper cardMapper, GenerateCardUseCase generateCardUseCase, FindCardIdUseCase cardIdUseCase, activeCardUseCase activeCardUseCase, BloquedCardUseCase bloquedCardUseCase) {
        this.cardMapper = cardMapper;
        this.generateCardUseCase = generateCardUseCase;
        this.cardIdUseCase = cardIdUseCase;
        this.activeCardUseCase = activeCardUseCase;
        this.bloquedCardUseCase = bloquedCardUseCase;
    }

    @PostMapping
    public ResponseEntity<CardResponse> generateCard(@Valid  @RequestBody CardRequest cardRequest) {
        Card card = generateCardUseCase.generateCard(cardRequest);

        return new ResponseEntity<>(cardMapper.toResponse(card), HttpStatus.CREATED);

    }

    @GetMapping("/{cardId}")
    public ResponseEntity<Card> getCard(@PathVariable("cardId") Long cardId) {
        return new ResponseEntity<>(cardIdUseCase.execute(cardId),HttpStatus.OK);
    }

    @PostMapping("/{cardId}/active")
    public ResponseEntity<CardActiveResponse> activeCard(@PathVariable("cardId") Long cardId) {
        return new ResponseEntity<>(activeCardUseCase.execute(cardId),HttpStatus.OK);

    }

    @PostMapping("/{cardId}/block")
    public ResponseEntity<CardActiveResponse> blockCard(@RequestBody CardBlockRequest cardBlockRequest, @PathVariable("cardId") Long cardId) {
        return new ResponseEntity<>(bloquedCardUseCase.execute(cardId,cardBlockRequest),HttpStatus.OK);

    }

}
