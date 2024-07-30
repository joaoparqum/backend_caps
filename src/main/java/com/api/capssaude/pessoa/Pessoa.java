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

    @NotNull(message = "O nome não pode ser nulo!")
    private String nome;

    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 caracteres!")
    @NotNull(message = "O CPF não pode ser nulo!")
    private String cpf;

    @NotNull(message = "A Data de nascimento não pode ser nula!")
    private Date dataDeNascimento;

    @Size(min = 9, max = 9, message = "O CEP deve ter exatamente 8 caracteres!")
    @NotNull(message = "O CEP não pode ser nulo!")
    private String cep;

    @NotNull(message = "O bairro não pode ser nulo!")
    private String bairro;
    @NotNull(message = "O logradouro não pode ser nulo!")
    private String logradouro;

    private String complemento;

    @Size(min = 11, max = 11, message = "O Telefone deve ter exatamente 9 caracteres!")
    private String telefone;

}
