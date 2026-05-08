package com.jcr.prueba.infraestruture.web.response;

import com.jcr.prueba.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardActiveResponse {

    private Long cardId;
    private Status status;
}
