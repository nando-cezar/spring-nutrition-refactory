package br.edu.ifba.nutrition.service;

import br.edu.ifba.nutrition.domain.dto.request.RequestComentarioDTO;
import br.edu.ifba.nutrition.entity.Comentario;
import br.edu.ifba.nutrition.repository.ComentarioRepository;
import br.edu.ifba.nutrition.repository.DicaRepository;
import br.edu.ifba.nutrition.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DicaRepository dicaRepository;

    public Void save(RequestComentarioDTO request){

        var usuario = usuarioRepository.findByUsername(request.usuarioUsername());
        var dica = dicaRepository.findById(request.dicaId());

        if(usuario.isPresent() && dica.isPresent()){
            comentarioRepository.save(
                    new Comentario(
                            request.dataHora(),
                            request.text(),
                            usuario.get(),
                            dica.get()
                    )
            );
        }

        return null;
    }
}
