package br.edu.ifba.nutrition.controller;

import br.edu.ifba.nutrition.domain.dto.request.RequestComentarioDTO;
import br.edu.ifba.nutrition.domain.dto.request.RequestDicaDTO;
import br.edu.ifba.nutrition.domain.dto.response.ResponseDicaDTO;
import br.edu.ifba.nutrition.service.DicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/dicas")
public class DicaController {

    @Autowired
    private DicaService service;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RequestDicaDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @GetMapping
    public ResponseEntity<Page<ResponseDicaDTO>> findAll(@RequestParam int page, @RequestParam int size){
        Sort sort = Sort.by(Sort.Direction.ASC, "titulo");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<ResponseDicaDTO> update(@PathVariable Long id, @RequestBody RequestDicaDTO request){
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.deleteById(id));
    }
}
