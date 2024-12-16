package com.example.bibliotecaSpring.Converter;

import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.DTO.UtenteDTO;
import com.example.bibliotecaSpring.Entity.Prestito;
import com.example.bibliotecaSpring.Entity.Utente;

import java.util.List;

public class UtenteConverter {

    public static UtenteDTO toDTO(Utente utente) {
        UtenteDTO utenteDTO = new UtenteDTO();
        utenteDTO.setIdu(utente.getIdu());
        utenteDTO.setNome(utente.getNome());
        utenteDTO.setCognome(utente.getCognome());
        List<PrestitoDTO> prestiti=utente.getPrestiti().stream().map(PrestitoConverter::toDTOwithoutUtente).toList();
        utenteDTO.setPrestiti(prestiti);
        return utenteDTO;
    }


}
