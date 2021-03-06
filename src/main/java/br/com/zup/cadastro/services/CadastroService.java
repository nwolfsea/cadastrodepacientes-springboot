package br.com.zup.cadastro.services;

import br.com.zup.cadastro.models.Cadastro;
import br.com.zup.cadastro.models.Historico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroService {
    private static List<Cadastro> cadastros = new ArrayList<>();

    @Autowired
    private HistoricoService historicoService;

    public Cadastro cadastrar(Cadastro cadastro) throws RuntimeException{
        if(!cadastros.contains(cadastros)){
            cadastros.add(cadastro);
            return cadastro;
        }
        throw new RuntimeException("O paciente com o CPF" + cadastro.getCpf()+ "já está cadastrado!");
    }

    public Cadastro cadastrarHistorico(String cpf, Historico historico) throws RuntimeException {
        for(Cadastro cadastro : cadastros){
            if (cadastro.getCpf().equalsIgnoreCase(cpf)) {
                historicoService.cadastrar(cadastro, historico);
                return cadastro;
            }
        }
        throw new RuntimeException("O paciente com CPF " + cpf + " não foi localizado");
    }

    public void adicionarCadastro(Cadastro cadastro) {
        cadastros.add(cadastro);
    }

    public List<Cadastro> getCadastros() {
        return cadastros;
    }

    public Cadastro pesquisar(String cpf) throws RuntimeException {
       Cadastro cadastro = new Cadastro();
        cadastro.setCpf(cpf);
        return pesquisar(cadastro);
    }

    public Cadastro pesquisar(Cadastro cadastro) throws RuntimeException {
        for(Cadastro cadastro1 : cadastros) {
            if (cadastro1.getCpf().equalsIgnoreCase(cadastro.getCpf())) {
                return cadastro1;
            }
        }
        throw new RuntimeException("O paciente com CPF " + cadastro.getCpf() + "já está cadastrado");
    }




}
