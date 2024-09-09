package com.api.capssaude.model;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB_RelatorioMedico")
@Data
public class RelatorioMedico implements Serializable{
   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private Consulta consulta;

    @OneToOne
    private Medico medico;
    
    private String descricaoDaDemanda;
    private String pricedimento;
    private String analise;
    private String conclusao;

}
