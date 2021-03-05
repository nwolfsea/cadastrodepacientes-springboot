package br.com.zup.cadastro.models;

import java.time.LocalDate;

public class ConsultaMedica {
    private String paciente;
    private LocalDate dataConsulta;
    private String tipoDaConsulta;

    public ConsultaMedica() {
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getTipoDaConsulta() {
        return tipoDaConsulta;
    }

    public void setTipoDaConsulta(String tipoDaConsulta) {
        this.tipoDaConsulta = tipoDaConsulta;
    }

    public void adicionarConsulta(ConsultaMedica consultaMedica) {
    }
}
