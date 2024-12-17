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

    public UtenteDTO saveUtente(UtenteDTO utenteDTO) {
        Utente utente = new Utente();
        utente.setNome(utenteDTO.getNome());
        utente.setCognome(utenteDTO.getCognome());
        utenteRepository.save(utente);
        return UtenteConverter.toDTO(utente);
    }

    public UtenteDTO updateUtente(int id, UtenteDTO utenteDTO) {
        Utente utente = utenteRepository.findById(id).orElseThrow(()-> new NoSuchElementException("utente non trovato"));
        utente.setNome(utenteDTO.getNome());
        utente.setCognome(utenteDTO.getCognome());
        utenteRepository.save(utente);
        return UtenteConverter.toDTO(utente);
    }

    public UtenteDTO deleteUtente(int id) {
        Utente utente=utenteRepository.findById(id).orElseThrow(()-> new NoSuchElementException("utente non trovato"));

        utenteRepository.delete(utente);
        return UtenteConverter.toDTO(utente);
    }


}
