package com.api.capssaude.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.capssaude.dto.EstoqueDTO;
import com.api.capssaude.interfaces.IEstoqueControl;
import com.api.capssaude.model.Estoque;
import com.api.capssaude.service.EstoqueService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/caps/estoque")
public class EstoqueController implements IEstoqueControl{

     final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService){
        this.estoqueService =  estoqueService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> saveEstoque(@RequestBody @Valid EstoqueDTO estoqueDTO) {
        Estoque estoque = new Estoque();
        BeanUtils.copyProperties(estoqueDTO, estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueService.save(estoque));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Estoque>> getAllEstoque() {
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEstoque(@PathVariable(value = "id") UUID id) {
        Optional<Estoque> estoque = estoqueService.findById(id);
        if (!estoque.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("estoque não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(estoque.get());
    }

    @Override
     @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEstoque(@PathVariable(value = "id") UUID id) {
        Optional<Estoque> estoqueOptional = estoqueService.findById(id);
        if (!estoqueOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estoque não encontrado!");
        }
        estoqueService.delete(estoqueOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Estoque deletado com sucesso!");
    }

    @Override
     @PutMapping("/{id}")
    public ResponseEntity<Object> updateEstoque(@PathVariable(value = "id") UUID id,
                                                  @RequestBody @Valid EstoqueDTO estoqueDTO) {
                         Optional<Estoque> estoqueOptional = estoqueService.findById(id);
        if (!estoqueOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estoque não encontrado!");
        }
        Estoque estoque = new Estoque();
        BeanUtils.copyProperties(estoqueDTO, estoque);
        estoque.setId(estoqueOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(estoqueService.save(estoque));
                           

    }
    
}
