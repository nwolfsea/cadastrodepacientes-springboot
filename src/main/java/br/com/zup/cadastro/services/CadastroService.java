package br.com.zup.cadastro.services;

import br.com.zup.cadastro.models.Cadastro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroService {
    private static List<Cadastro> cadastros = new ArrayList<>();

    public void adicionarCadastro(Cadastro cadastro) {
        cadastros.add(cadastro);
    }

    public List<Cadastro> getCadastros() {
        return cadastros;
    }

    public Cadastro pesquisarCadastro (String nome){
        for (Cadastro cadastro : cadastros) {
            if(nome.equals(cadastro.getNome())){
               return cadastro;
            }
        }
        return null;
    }
}
