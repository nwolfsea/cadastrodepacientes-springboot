package br.com.zup.cadastro.services;

import br.com.zup.cadastro.models.Cadastro;
import br.com.zup.cadastro.models.Historico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService {

    @Autowired
   private CadastroService cadastroService;

   public Historico registrarHistorico(String cpf, Historico historico){
       Cadastro cadastro = cadastroService.pesquisar(cpf);
       cadastro.getHistoricos().add(historico);

       return historico;
   }
}
