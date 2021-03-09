package br.com.zup.cadastro.controllers;

import br.com.zup.cadastro.DTO.CadastroPacienteDTO;
import br.com.zup.cadastro.models.Cadastro;
import br.com.zup.cadastro.models.Historico;
import br.com.zup.cadastro.services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("cadastro/")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cadastro cadastrarPaciente(@RequestBody @Valid CadastroPacienteDTO cadastroPacienteDTO) {
        Cadastro objetoCadastro = cadastroService.cadastrar(cadastroPacienteDTO.converterDTOParaCadastro());
        return objetoCadastro;
    }

    @PutMapping("historico")
    @ResponseStatus(HttpStatus.CREATED)
    public Cadastro cadastrarHistorico(@RequestParam("cpf") String cpf, @RequestBody Historico historico) {
        try {
            return cadastroService.cadastrarHistorico(cpf, historico);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{cpf}/")
    @ResponseStatus(HttpStatus.OK)
    public Cadastro pesquisarPaciente(@PathVariable String cpf) {
        Cadastro cadastro = cadastroService.pesquisar(cpf);
        return cadastro;
    }
}

