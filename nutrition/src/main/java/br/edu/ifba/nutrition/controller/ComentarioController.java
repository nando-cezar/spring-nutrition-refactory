package br.edu.ifba.nutrition.controller;

import br.edu.ifba.nutrition.domain.dto.request.RequestComentarioDTO;
import br.edu.ifba.nutrition.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RequestComentarioDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

}
