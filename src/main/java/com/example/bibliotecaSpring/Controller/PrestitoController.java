package com.example.bibliotecaSpring.Controller;

import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.Service.PrestitoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prestito")
public class PrestitoController {

    private final PrestitoService prestitoService;

    public PrestitoController(PrestitoService prestitoService) {
        this.prestitoService = prestitoService;
    }

    @GetMapping("/getPrestitoById/{id}")
    public PrestitoDTO getPrestitoById(@PathVariable("id") Integer id) {
       return prestitoService.getPrestitoById(id);
    }

    @GetMapping("")
    public List<PrestitoDTO> getAllPrestito() {
        return prestitoService.getAllPrestito();
    }
}
