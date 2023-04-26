package br.edu.ifba.nutrition.domain.dto.request;

import br.edu.ifba.nutrition.domain.enums.Categoria;
import br.edu.ifba.nutrition.entity.Dica;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record RequestDicaDTO (String titulo, String foto, String texto, Categoria categoria){

}
