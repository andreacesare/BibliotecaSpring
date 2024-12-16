package com.example.bibliotecaSpring.Converter;

import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.Entity.Prestito;

public class PrestitoConverter {

        public static PrestitoDTO toDTO(Prestito prestito) {
            PrestitoDTO prestitoDTO = new PrestitoDTO();
            prestitoDTO.setIdp(prestito.getIdp());
            prestitoDTO.setInizio(prestito.getInizio());
            prestitoDTO.setFine(prestito.getFine()!=null?prestito.getFine():null);
            prestitoDTO.setLibro(LibroConverter.toDTO(prestito.getLibro()));
            prestitoDTO.setUtente(UtenteConverter.toDTO(prestito.getUtente()));
            return prestitoDTO;
        }

        public static PrestitoDTO toDTOwithoutUtente(Prestito prestito) {
            PrestitoDTO prestitoDTO = new PrestitoDTO();
            prestitoDTO.setIdp(prestito.getIdp());
            prestitoDTO.setInizio(prestito.getInizio());
            prestitoDTO.setFine(prestito.getFine()!=null?prestito.getFine():null);
            prestitoDTO.setLibro(LibroConverter.toDTO(prestito.getLibro()));
            return prestitoDTO;
        }
}
