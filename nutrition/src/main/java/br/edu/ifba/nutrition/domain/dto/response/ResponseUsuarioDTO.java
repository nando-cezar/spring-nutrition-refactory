package br.edu.ifba.nutrition.domain.dto.response;

import br.edu.ifba.nutrition.entity.Usuario;

public record ResponseUsuarioDTO(Long id, String username) {

    public ResponseUsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getUsername());
    }
}
