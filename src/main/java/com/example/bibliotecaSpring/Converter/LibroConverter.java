package com.example.bibliotecaSpring.Converter;

import com.example.bibliotecaSpring.DTO.LibroDTO;
import com.example.bibliotecaSpring.Entity.Libro;

public class LibroConverter {

    public static LibroDTO toDTO(Libro libro){
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setIdl(libro.getIdl());
        libroDTO.setAutore(libro.getAutore());
        libroDTO.setTitolo(libro.getTitolo());
        return libroDTO;
    }

    public static Libro toEntity(LibroDTO libroDTO){
        Libro libro = new Libro();
        libro.setIdl(libroDTO.getIdl());
        libro.setAutore(libroDTO.getAutore());
        libro.setTitolo(libroDTO.getTitolo());
        return libro;

    }


}
