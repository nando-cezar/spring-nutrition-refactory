package br.edu.ifba.nutrition.domain.dto.request;

import java.time.LocalDateTime;

public record RequestComentarioDTO(LocalDateTime dataHora, String text, String usuarioUsername, Long dicaId) {
}
