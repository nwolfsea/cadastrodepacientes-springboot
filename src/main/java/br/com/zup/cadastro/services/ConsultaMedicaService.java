package br.com.zup.cadastro.services;

import br.com.zup.cadastro.models.ConsultaMedica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaMedicaService {
    @Autowired
    private CadastroService cadastroService;

    List<ConsultaMedica> consultaMedicas = new ArrayList<>();
}
