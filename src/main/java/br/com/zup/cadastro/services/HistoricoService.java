package br.com.zup.cadastro.services;

import br.com.zup.cadastro.models.Cadastro;
import br.com.zup.cadastro.models.Historico;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService {
    public Historico cadastrar(Cadastro cadastro, Historico historico) {
        cadastro.getHistoricos().add(historico);
        return historico;
    }
}
