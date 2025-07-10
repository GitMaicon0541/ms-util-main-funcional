package br.edu.ifrs.riogrande.tads.tds.util.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifrs.riogrande.tads.tds.util.service.nomeValidoService;

@RestController
public class nomeValidoController {

    private final nomeValidoService nomeValidoService;

    public nomeValidoController(nomeValidoService nomeValidoService) {
        this.nomeValidoService = nomeValidoService;
    }
    
    @GetMapping(
        value = "/nomeValido", 
        produces = MediaType.TEXT_PLAIN_VALUE)

    public String nomeValido() {
        return nomeValidoService.nomeValido();
    }
}