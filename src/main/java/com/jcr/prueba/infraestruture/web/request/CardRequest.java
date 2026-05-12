package com.jcr.prueba.infraestruture.web.request;

import jakarta.validation.constraints.Pattern;

public record CardRequest(
            @Pattern(
                    regexp = "\\d{6}",
                    message = "El productId debe tener exactamente 6 dígitos"
            )
            String productId, String holderName) {
}
