package com.example.bibliotecaSpring.Service;

import com.example.bibliotecaSpring.Converter.LibroConverter;
import com.example.bibliotecaSpring.DTO.LibroDTO;
import com.example.bibliotecaSpring.Entity.Libro;
import com.example.bibliotecaSpring.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LibroService {
    LibroRepository libroRepository;
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public LibroDTO getLibroById(String id) {
        Libro libro= libroRepository.findById(id).orElseThrow(()->new NoSuchElementException("Libro not found"));
        return LibroConverter.toDTO(libro);
    }

    public List<LibroDTO> getAllLibro() {
        return libroRepository.findAll().stream().map(LibroConverter::toDTO).toList();
    }
}
