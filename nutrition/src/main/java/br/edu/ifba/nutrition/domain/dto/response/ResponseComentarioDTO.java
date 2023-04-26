package br.edu.ifba.nutrition.domain.dto.response;

import br.edu.ifba.nutrition.entity.Comentario;

import java.time.LocalDateTime;

public record ResponseComentarioDTO(Long id, LocalDateTime dataHora, String text) {

    public ResponseComentarioDTO(Comentario entity){
        this(entity.getId(), entity.getDataHora(), entity.getText());
    }
}
