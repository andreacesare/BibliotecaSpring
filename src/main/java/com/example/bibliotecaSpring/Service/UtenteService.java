package com.example.bibliotecaSpring.Service;

import com.example.bibliotecaSpring.Converter.UtenteConverter;
import com.example.bibliotecaSpring.DTO.UtenteDTO;
import com.example.bibliotecaSpring.Entity.Utente;
import com.example.bibliotecaSpring.Repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UtenteService {
    UtenteRepository utenteRepository;
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public UtenteDTO getUtenteById(int id) {
        Utente utente = utenteRepository.findById(id).orElseThrow(()-> new NoSuchElementException("utente non trovato"));
        UtenteDTO utenteDTO = UtenteConverter.toDTO(utente);
        return utenteDTO;
    }
    public List<UtenteDTO> getAllUtenti() {
        return utenteRepository.findAll().stream().map(UtenteConverter::toDTO).toList();
    }


}
