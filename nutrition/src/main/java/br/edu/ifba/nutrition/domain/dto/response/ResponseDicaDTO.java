package br.edu.ifba.nutrition.domain.dto.response;

import br.edu.ifba.nutrition.domain.enums.Categoria;
import br.edu.ifba.nutrition.entity.Comentario;
import br.edu.ifba.nutrition.entity.Dica;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.stream.Collectors;

public record ResponseDicaDTO(Long id, String titulo, String foto, String texto, Categoria categoria, List<ResponseComentarioDTO> comentarios, boolean status) {
    public ResponseDicaDTO(Dica entity){
        this(
                entity.getId(),
                entity.getTitulo(),
                entity.getFoto(),
                entity.getTexto(),
                entity.getCategoria(),
                entity.getComentarios().stream().map(ResponseComentarioDTO::new).collect(Collectors.toList()),
                entity.isAtivo()
        );
    }
}
