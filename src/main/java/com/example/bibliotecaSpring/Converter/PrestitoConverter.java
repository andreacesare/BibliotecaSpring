package com.example.bibliotecaSpring.Converter;

import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.Entity.Libro;
import com.example.bibliotecaSpring.Entity.Prestito;
import com.example.bibliotecaSpring.Entity.Utente;
import com.example.bibliotecaSpring.Repository.LibroRepository;
import com.example.bibliotecaSpring.Repository.PrestitoRepository;
import com.example.bibliotecaSpring.Repository.UtenteRepository;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
@Component
public class PrestitoConverter {
  UtenteRepository utenteRepository;
  LibroRepository libroRepository;
  public PrestitoConverter(UtenteRepository utenteRepository, LibroRepository libroRepository) {
      this.libroRepository = libroRepository;
      this.utenteRepository=utenteRepository;
  }

        public static PrestitoDTO toDTO(Prestito prestito) {
            PrestitoDTO prestitoDTO = new PrestitoDTO();
            prestitoDTO.setIdp(prestito.getIdp());
            prestitoDTO.setInizio(prestito.getInizio());
            prestitoDTO.setFine(prestito.getFine()!=null?prestito.getFine():null);
            prestitoDTO.setLibro(LibroConverter.toDTO(prestito.getLibro()));
            prestitoDTO.setUtente(UtenteConverter.toDTO(prestito.getUtente()));
            prestitoDTO.getUtente().setPrestiti(null);
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

        public  Prestito toEntity(PrestitoDTO prestitoDTO) {
            Prestito prestito = new Prestito();
            prestito.setIdp(prestitoDTO.getIdp());
            prestito.setInizio(prestitoDTO.getInizio());
            prestito.setFine(prestitoDTO.getFine());
            Utente utente=utenteRepository.findById(prestitoDTO.getUtente().getIdu()).orElseThrow(()->new NoSuchElementException("utente non trovato"));
            Libro libro=libroRepository.findById(prestitoDTO.getLibro().getIdl()).orElseThrow(()->new NoSuchElementException("libro non trovato"));
            prestito.setUtente(utente);
            prestito.setLibro(libro);
            return prestito;
        }
}
