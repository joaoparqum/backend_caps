package com.api.capssaude.interfaces;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.capssaude.dto.EstoqueDTO;
import com.api.capssaude.model.Estoque;

import jakarta.validation.Valid;

public interface IEstoqueControl{

     public ResponseEntity<Object> saveEstoque(@RequestBody @Valid EstoqueDTO estoqueDTO);
    public ResponseEntity<List<Estoque>> getAllEstoque();
    public ResponseEntity<Object> getOneEstoque(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> deleteEstoque(@PathVariable(value = "id") UUID id);
    public ResponseEntity<Object> updateEstoque(@PathVariable(value = "id") UUID id, 
                                             @RequestBody @Valid EstoqueDTO estoqueDTO); 
}