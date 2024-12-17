package com.example.bibliotecaSpring.Controller;
import com.example.bibliotecaSpring.DTO.LibroDTO;
import com.example.bibliotecaSpring.DTO.UtenteDTO;
import com.example.bibliotecaSpring.DTO.UtenteLibroDTO;
import com.example.bibliotecaSpring.Entity.Utente;
import com.example.bibliotecaSpring.Service.UtenteService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/saveUtente")
    public UtenteDTO saveUtente(@RequestBody UtenteDTO utenteDTO) {
        return utenteService.saveUtente(utenteDTO);
    }

    @PutMapping("/updateUtente/{id}")
    public UtenteDTO updateUtente(@PathVariable("id") Integer id, @RequestBody UtenteDTO utenteDTO) {
        return utenteService.updateUtente(id, utenteDTO);
    }

    @DeleteMapping("/deleteUtente/{id}")
    public  UtenteDTO deleteUtente(@PathVariable("id") Integer id) {
        return utenteService.deleteUtente(id);
    }

//    @GetMapping("/libriNonRientrati")
//    public List<UtenteDTO> getLibriNonRientrati() {
//        return utenteService.utentiLibriNrientrati();
//    }
    @GetMapping("/libriNonRientrati")
    public List<UtenteLibroDTO> getLibriNonRientrati() {
        return utenteService.libriNonRientrati();
    }

    @GetMapping("/{id}/libri")
    public List<LibroDTO> getLibri(@PathVariable("id") Integer id) {
        return utenteService.libriUtente(id);
    }

}
