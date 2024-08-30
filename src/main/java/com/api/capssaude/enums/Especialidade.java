package com.api.capssaude.enums;

public enum Especialidade {

    MEDICO("CRM"),
    ENFERMEIRO("COREN"),
    PSICOLOGO("CRP"),
    TERAPEUTA("CREFITO");

    private final String codigoRegistro;

    Especialidade(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }
}
