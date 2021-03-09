package br.com.zup.cadastro.controllers;

import br.com.zup.cadastro.models.Historico;
import br.com.zup.cadastro.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("historicos/")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @PostMapping("{cpf}/")
    public Historico registrarHistorico(@RequestBody Historico historico, @PathVariable String cpf){
        try {
            Historico objHistorico = historicoService.registrarHistorico(cpf, historico);
            return objHistorico;
        }catch (RuntimeException error){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.getMessage());
        }
    }
}
