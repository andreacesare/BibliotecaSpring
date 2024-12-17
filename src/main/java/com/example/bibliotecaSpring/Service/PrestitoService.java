package com.example.bibliotecaSpring.Service;

import com.example.bibliotecaSpring.Converter.PrestitoConverter;
import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.Entity.Prestito;
import com.example.bibliotecaSpring.Repository.LibroRepository;
import com.example.bibliotecaSpring.Repository.PrestitoRepository;
import com.example.bibliotecaSpring.Repository.UtenteRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PrestitoService {

    PrestitoRepository prestitoRepository;
    PrestitoConverter prestitoConverter;
    UtenteRepository utenteRepository;
    LibroRepository libroRepository;

    public PrestitoService(PrestitoRepository prestitoRepository, PrestitoConverter prestitoConverter, UtenteRepository utenteRepository, LibroRepository libroRepository) {
        this.prestitoRepository = prestitoRepository;
        this.prestitoConverter = prestitoConverter;
        this.utenteRepository = utenteRepository;
        this.libroRepository = libroRepository;
    }

    public PrestitoDTO getPrestitoById(int id) {
        Prestito prestito = prestitoRepository.findById(id).orElseThrow(() -> new NullPointerException("Prestito id not found"));
        PrestitoDTO pdto = PrestitoConverter.toDTO(prestito);
        pdto.getUtente().setPrestiti(null);
        return pdto;
    }

    public List<PrestitoDTO> getAllPrestito() {
        List<PrestitoDTO> p = prestitoRepository.findAll().stream().map(PrestitoConverter::toDTO).toList();
        p.stream().forEach(pr -> pr.getUtente().setPrestiti(null));
        return p;
    }

    public PrestitoDTO savePrestito(PrestitoDTO pdto) {
        Prestito prestito = prestitoConverter.toEntity(pdto);
        prestitoRepository.save(prestito);
        return PrestitoConverter.toDTO(prestito);
    }

    public PrestitoDTO updatePrestito(Integer id, PrestitoDTO pdto) {
        Prestito prestito = prestitoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Prestito id not found"));
        if (pdto.getInizio() != null) {
            prestito.setInizio(pdto.getInizio());
        }
        if (pdto.getFine() != null) {
            prestito.setFine(pdto.getFine());
        }
        if (pdto.getUtente() != null) {
            prestito.setUtente(utenteRepository.findById(pdto.getUtente().getIdu()).orElseThrow(() -> new NoSuchElementException("Utente id not found")));
        }
        if (pdto.getLibro() != null) {
            prestito.setLibro(libroRepository.findById(pdto.getLibro().getIdl()).orElseThrow(() -> new NoSuchElementException("Libro id not found")));
        }
        return PrestitoConverter.toDTO(prestitoRepository.save(prestito));
    }

    public PrestitoDTO deletePrestito(Integer id) {
        Prestito prestito = prestitoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Prestito id not found"));
        prestitoRepository.delete(prestito);
        return PrestitoConverter.toDTO(prestito);
    }

    public List<PrestitoDTO> getPrestiti15gg(){
        List<PrestitoDTO> lista=prestitoRepository.findAll()
                .stream()
                .filter(p->{
                    LocalDate fine=p.getFine()!=null?p.getFine(): LocalDate.now(); long durata= ChronoUnit.DAYS.between(p.getInizio(),fine); return durata>15;
                })
                .map(PrestitoConverter::toDTO).toList();
        return lista;
    }

}

