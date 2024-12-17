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

    public LibroDTO saveLibro(LibroDTO libroDTO) {
        Libro libro = LibroConverter.toEntity(libroDTO);
        libroRepository.save(libro);
        return LibroConverter.toDTO(libro);
    }

    public LibroDTO updateLibro(String id, LibroDTO libroDTO) {
        Libro libro=libroRepository.findById(id).orElseThrow(()->new NoSuchElementException("Libro not found"));
        libro.setAutore(libroDTO.getAutore());
        libro.setTitolo(libroDTO.getTitolo());
        libroRepository.save(libro);
        return LibroConverter.toDTO(libro);
    }

    public LibroDTO deleteLibro(String id) {
        Libro libro=libroRepository.findById(id).orElseThrow(()->new NoSuchElementException("Libro not found"));
        libroRepository.delete(libro);
        return LibroConverter.toDTO(libro);
    }
}
