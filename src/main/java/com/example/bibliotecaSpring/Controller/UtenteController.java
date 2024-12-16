package com.example.bibliotecaSpring.Controller;

import com.example.bibliotecaSpring.DTO.UtenteDTO;
import com.example.bibliotecaSpring.Service.UtenteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    UtenteService utenteService;
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/getUtenteById/{id}")
    public UtenteDTO getUtenteById(@PathVariable("id") Integer id) {
        return utenteService.getUtenteById(id);
    }
    @GetMapping("")
    public List<UtenteDTO> getAllUtente() {
        return utenteService.getAllUtenti();
    }
}
