package com.example.bibliotecaSpring.Controller;

import com.example.bibliotecaSpring.DTO.LibroDTO;
import com.example.bibliotecaSpring.Service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {
    LibroService libroService;
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/getLibroById/{id}")
    public LibroDTO getLibroById(@PathVariable("id") String id) {
        return libroService.getLibroById(id);
    }

    @GetMapping("")
    public List<LibroDTO> getAllLibro() {
        return libroService.getAllLibro();
    }


}
