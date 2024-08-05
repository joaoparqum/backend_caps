package com.api.capssaude.controller;

import java.util.List;

import java.util.Optional;
import org.hibernate.validator.constraints.UUID;
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

import com.api.capssaude.dto.MedicamentoDTO;
import com.api.capssaude.interfaces.IMedicamentoControl;
import com.api.capssaude.model.Consulta;
import com.api.capssaude.model.Medicamento;
import com.api.capssaude.service.MedicamentoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/caps/medicamento")
public class MedicamentoController implements IMedicamentoControl{
    
    final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService){
        this.medicamentoService = medicamentoService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> saveMedicamento(@RequestBody @Valid MedicamentoDTO medicamentoDTO) {

         Medicamento medicamento = new Medicamento();
        BeanUtils.copyProperties(medicamentoDTO, medicamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicamentoService.save(medicamento));
        
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Medicamento>> getAllMedicamento() {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicamentoService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMedicamento(@PathVariable(value = "id")UUID id) {

        Optional<Medicamento> medicamento = medicamentoService.findById(id);
        if (!medicamento.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicamento não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicamento.get());
       
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMedicamento(@PathVariable(value = "id")UUID id) {
        Optional<Medicamento> medicamentoOptional = medicamentoService.findById(id);
        if (!medicamentoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicamento não encontrado!");
        }
        medicamentoService.delete(medicamentoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Medicamento deletado com sucesso!");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMedicamento(@PathVariable(value = "id") UUID id, @RequestBody @Valid MedicamentoDTO medicamentoDTO) {

        Optional<Medicamento> medicamentoOptional = medicamentoService.findById(id);
        if (!medicamentoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicamento não encontrado!");
        }
        Medicamento medicamento = new Medicamento();
        BeanUtils.copyProperties(medicamentoDTO, medicamento);
        medicamento.setId(medicamentoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.save(medicamento));
        
    }
}
