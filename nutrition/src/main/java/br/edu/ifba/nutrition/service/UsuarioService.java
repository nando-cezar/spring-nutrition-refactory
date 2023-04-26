package br.edu.ifba.nutrition.service;

import br.edu.ifba.nutrition.domain.dto.request.RequestUsuarioDTO;
import br.edu.ifba.nutrition.domain.dto.response.ResponseUsuarioDTO;
import br.edu.ifba.nutrition.entity.Usuario;
import br.edu.ifba.nutrition.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Void save(RequestUsuarioDTO request){
        repository.save(new Usuario(request));
        return null;
    }
    public Page<ResponseUsuarioDTO> findAll(Pageable pageable){
        return repository.findAll(pageable).map(ResponseUsuarioDTO::new);
    }

}
