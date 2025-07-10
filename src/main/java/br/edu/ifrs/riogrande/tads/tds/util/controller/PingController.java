package br.edu.ifrs.riogrande.tads.tds.util.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.tds.util.service.PingService;

@RestController
public class PingController {

    private final PingService pingService;

    public PingController(PingService pingService) {
        this.pingService = pingService;
    }

    @GetMapping(
        value = "/ping", 
        produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping() {
        String resp = pingService.ping();

        return resp;
    }

}
