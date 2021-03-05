package br.com.zup.cadastro.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Historico {

    LocalDate dataDoRegistro;
    String notaHistorico;

    private static
    List<Historico> listarPacientes = new ArrayList<>();
}
