package com.example.bibliotecaSpring.Service;

import com.example.bibliotecaSpring.Converter.UtenteConverter;
import com.example.bibliotecaSpring.DTO.LibroDTO;
import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.DTO.UtenteDTO;
import com.example.bibliotecaSpring.DTO.UtenteLibroDTO;
import com.example.bibliotecaSpring.Entity.Prestito;
import com.example.bibliotecaSpring.Entity.Utente;
import com.example.bibliotecaSpring.Repository.PrestitoRepository;
import com.example.bibliotecaSpring.Repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UtenteService {
    UtenteRepository utenteRepository;
    PrestitoRepository prestitoRepository;
    public UtenteService(UtenteRepository utenteRepository,PrestitoRepository prestitoRepository) {
        this.utenteRepository = utenteRepository;
        this.prestitoRepository = prestitoRepository;
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

//    public List<UtenteDTO> utentiLibriNrientrati(){
//        List<UtenteDTO> lista=prestitoRepository.findAll()
//                .stream()
//                .filter(p->p.getFine()==null)
//                .map(Prestito::getUtente)
//                .map(UtenteConverter::toDTO)
//                .toList();
//        return lista;
//    }
    public List<UtenteLibroDTO> libriNonRientrati(){
        List<Object[]> lista =utenteRepository.libriNonRientrati();
        List<UtenteLibroDTO> dto = new ArrayList<>();
        for(Object[] row:lista){
            Integer id = (Integer) row[0];
            String nome = (String) row[1];
            String cognome=(String) row[2];
            String titolo=(String) row[3];
            dto.add(new UtenteLibroDTO(id,nome,cognome,titolo));
        }
        return dto;
    }

    public List<LibroDTO> libriUtente(Integer id){
        List<Object[]> lista=utenteRepository.libriUtente(id);
        List<LibroDTO> dto = new ArrayList<>();
        for(Object[] row:lista){
            String titolo = (String) row[0];
            String autore = (String) row[1];
            LocalDate inizio = (LocalDate) row[2];
            LocalDate fine = (LocalDate) row[3];
            dto.add(new LibroDTO(titolo,autore,inizio,fine));
        }
        return dto;


    }






}
