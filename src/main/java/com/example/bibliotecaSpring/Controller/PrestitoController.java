package com.example.bibliotecaSpring.Controller;

import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.Repository.PrestitoRepository;
import com.example.bibliotecaSpring.Service.PrestitoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestito")
public class PrestitoController {

    private final PrestitoService prestitoService;
    private final PrestitoRepository prestitoRepository;

    public PrestitoController(PrestitoService prestitoService, PrestitoRepository prestitoRepository) {
        this.prestitoService = prestitoService;
        this.prestitoRepository = prestitoRepository;
    }

    @GetMapping("/getPrestitoById/{id}")
    public PrestitoDTO getPrestitoById(@PathVariable("id") Integer id) {
       return prestitoService.getPrestitoById(id);
    }

    @GetMapping("")
    public List<PrestitoDTO> getAllPrestito() {
        return prestitoService.getAllPrestito();
    }

    @PostMapping("/savePrestito")
    public PrestitoDTO savePrestito(@RequestBody PrestitoDTO prestito) {
        return prestitoService.savePrestito(prestito);
    }
    @PutMapping("/updatePrestito/{id}")
    public PrestitoDTO updatePrestito(@PathVariable("id") Integer id, @RequestBody PrestitoDTO prestito) {
        return prestitoService.updatePrestito(id, prestito);
    }
    @DeleteMapping("/deletePrestito/{id}")
    public PrestitoDTO deletePrestito(@PathVariable("id") Integer id) {
        return prestitoService.deletePrestito(id);
    }

    @GetMapping("/superioreA15gg")
    public List<PrestitoDTO> superioreA15gg() {
        return prestitoService.getPrestiti15gg();
    }





}
