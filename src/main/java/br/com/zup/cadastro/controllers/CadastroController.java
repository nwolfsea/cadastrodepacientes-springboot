package br.com.zup.cadastro.controllers;

import br.com.zup.cadastro.models.Cadastro;
import br.com.zup.cadastro.models.ConsultaMedica;
import br.com.zup.cadastro.services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cadastro/")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public List<Cadastro> adicionarCadastro (@RequestBody Cadastro cadastro){
        cadastroService.adicionarCadastro(cadastro);
        return cadastroService.getCadastros();
    }

    @PostMapping
    public String adicionarConsulta (@RequestBody ConsultaMedica consultaMedica){
        consultaMedica.adicionarConsulta(consultaMedica);
        return consultaMedica.getTipoDaConsulta();
    }

    @GetMapping
    public List<Cadastro> listarCadastro(){
        return cadastroService.getCadastros();
    }

    @GetMapping("{nome}/")
    public Cadastro pesquisarCadastroPeloNome(@PathVariable String nome){
      return cadastroService.pesquisarCadastro(nome);
    }

}
