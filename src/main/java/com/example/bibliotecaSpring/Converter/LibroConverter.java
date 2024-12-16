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


}
