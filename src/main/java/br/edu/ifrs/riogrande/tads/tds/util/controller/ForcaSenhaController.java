package br.edu.ifrs.riogrande.tads.tds.util.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifrs.riogrande.tads.tds.util.service.SenhaService;

@RestController
public class ForcaSenhaController {

    private final SenhaService senhaService;

    public ForcaSenhaController(SenhaService senhaService) {
        this.senhaService = senhaService;
    }

    @GetMapping(value = "/forca-senha/{senha}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String forcaSenha(@PathVariable String senha) {
        return senhaService.forcaSenha(senha);
    }
}