package br.edu.ifba.nutrition.controller;

import br.edu.ifba.nutrition.domain.dto.request.RequestUsuarioDTO;
import br.edu.ifba.nutrition.domain.dto.response.ResponseUsuarioDTO;
import br.edu.ifba.nutrition.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RequestUsuarioDTO request){
        ResponseEntity.ok().body(service.save(request));
        return null;
    }

    @GetMapping
    public ResponseEntity<Page<ResponseUsuarioDTO>> findAll(@RequestParam int page, @RequestParam int size){

        Sort sort = Sort.by(Sort.Direction.ASC, "username");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
}
