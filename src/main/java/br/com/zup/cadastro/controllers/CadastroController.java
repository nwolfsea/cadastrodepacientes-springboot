package br.com.zup.cadastro.controllers;

import br.com.zup.cadastro.models.Cadastro;
import br.com.zup.cadastro.models.ConsultaMedica;
import br.com.zup.cadastro.models.Historico;
import br.com.zup.cadastro.services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("cadastro/")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cadastro cadastro(@RequestBody Cadastro cadastro){
        try {
            cadastroService.adicionarCadastro(cadastro);
            return cadastro;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public String adicionarConsulta (@RequestBody ConsultaMedica consultaMedica){
        consultaMedica.adicionarConsulta(consultaMedica);
        return consultaMedica.getTipoDaConsulta();
    }

    @PutMapping("historico")
    @ResponseStatus(HttpStatus.CREATED)
    public Cadastro cadastrarHistorico(@RequestParam("cpf") String cpf, @RequestBody Historico historico){
        try{
            return cadastroService.cadastrarHistorico(cpf, historico);
        } catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{cpf}/")
    @ResponseStatus(HttpStatus.OK)
    public Cadastro pesquisarCadastro(@PathVariable String cpf);
    try{
        return cadastroService.pesquisar(cpf);
    } catch (RuntimeException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @GetMapping
    public List<Cadastro> listarCadastro(){
        return cadastroService.getCadastros();
    }

    @GetMapping("{nome}/")
    public Cadastro pesquisarCadastroPeloNome(@PathVariable String nome){
      return cadastroService.pesquisarCadastro(nome);
    }

    @DeleteMapping("{nome}")
    public void deletarConsulta(@PathVariable String nome){
        try {
            ConsultaMedica.deletarConsulta(nome);
        }catch (RuntimeException erro){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erro.getMessage());
        }
    }
}
