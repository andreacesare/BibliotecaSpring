package com.example.bibliotecaSpring.Service;

import com.example.bibliotecaSpring.Converter.LibroConverter;
import com.example.bibliotecaSpring.DTO.LibroDTO;
import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.Entity.Libro;
import com.example.bibliotecaSpring.Entity.Prestito;
import com.example.bibliotecaSpring.Repository.LibroRepository;
import com.example.bibliotecaSpring.Repository.PrestitoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LibroService {
    LibroRepository libroRepository;
    PrestitoRepository prestitoRepository;

    public LibroService(LibroRepository libroRepository,PrestitoRepository prestitoRepository) {
        this.libroRepository = libroRepository;
        this.prestitoRepository = prestitoRepository;
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

    public List<LibroDTO> libriUtente(Integer id){
        List<LibroDTO> libri=prestitoRepository.findAll().stream().filter(p->p.getUtente().getIdu().equals(id)).map(Prestito::getLibro).map(LibroConverter::toDTO).toList();
        return libri;
    }

}
