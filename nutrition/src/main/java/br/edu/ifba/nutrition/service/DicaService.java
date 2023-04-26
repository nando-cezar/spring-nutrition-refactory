package br.edu.ifba.nutrition.service;

import br.edu.ifba.nutrition.domain.dto.request.RequestDicaDTO;
import br.edu.ifba.nutrition.domain.dto.response.ResponseDicaDTO;
import br.edu.ifba.nutrition.entity.Dica;
import br.edu.ifba.nutrition.repository.DicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DicaService {

    @Autowired
    private DicaRepository repository;

    public Void save(RequestDicaDTO request){
        repository.save(new Dica(request));
        return null;
    }

    public ResponseDicaDTO update(Long id, RequestDicaDTO request){
        return repository.findById(id).map(record -> {
                record.setTitulo(request.titulo());
                record.setFoto(request.foto());
                record.setTexto(request.texto());
                record.setCategoria(request.categoria());

                return new ResponseDicaDTO(repository.save(record));
            }
        ).orElse(null);
    }

    public Page<ResponseDicaDTO> findAll(Pageable pageable){
        return repository.findAll(pageable).map(ResponseDicaDTO::new);
    }

    public Void deleteById(Long id){
        repository.findById(id).ifPresent(record -> {
                    record.setAtivo(false);
                    repository.save(record);
                }
        );
        return null;
    }
}
