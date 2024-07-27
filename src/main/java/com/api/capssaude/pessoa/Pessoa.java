package com.api.capssaude.pessoa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String nome;

    @Size(max = 11, message = "O CPF deve ter no máximo 11 caracteres")
    @NotNull
    private String cpf;

    @NotNull
    private Date dataDeNascimento;

    @Size(max = 8, message = "O CEP deve ter no máximo 8 caracteres")
    private String cep;

    private String bairro;
    private String logradouro;
    private String complemento;

    @Size(max = 9, message = "O Telefone deve ter no máximo 9 caracteres")
    private String telefone;

}
