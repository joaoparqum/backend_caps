package com.api.capssaude.dto;

import java.util.UUID;
import com.api.capssaude.model.Consulta;
import com.api.capssaude.model.Medico;

public record RelatorioMedicoDTO(
UUID Id,
Consulta consulta,
Medico medico,
String descricaoDaDemanda,
String procedimento,
String analise,
String conclusao

){
    
}
