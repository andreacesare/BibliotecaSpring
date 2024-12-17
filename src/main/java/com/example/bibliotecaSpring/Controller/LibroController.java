package com.example.bibliotecaSpring.Controller;

import com.example.bibliotecaSpring.DTO.LibroDTO;
import com.example.bibliotecaSpring.Service.LibroService;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/saveLibro")
    public LibroDTO saveLibro(@RequestBody LibroDTO libroDTO) {
        return libroService.saveLibro(libroDTO);
    }

    @PutMapping("/updateLibro/{id}")
    public LibroDTO updateLibro(@PathVariable("id") String id, @RequestBody LibroDTO libroDTO) {
        return libroService.updateLibro(id, libroDTO);
    }

    @DeleteMapping("/deleteLibro/{id}")
    public LibroDTO deleteLibro(@PathVariable("id") String id) {
        return libroService.deleteLibro(id);
    }

}
