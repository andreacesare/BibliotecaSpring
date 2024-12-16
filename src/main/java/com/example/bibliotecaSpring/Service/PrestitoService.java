package com.example.bibliotecaSpring.Service;

import com.example.bibliotecaSpring.Converter.PrestitoConverter;
import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.Entity.Prestito;
import com.example.bibliotecaSpring.Repository.PrestitoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestitoService {

    PrestitoRepository prestitoRepository;
    public PrestitoService(PrestitoRepository prestitoRepository) {
        this.prestitoRepository = prestitoRepository;
    }

    public PrestitoDTO getPrestitoById(int id) {
        Prestito prestito = prestitoRepository.findById(id).orElseThrow(()->new NullPointerException("Prestito id not found"));
        PrestitoDTO pdto=PrestitoConverter.toDTO(prestito);
        pdto.getUtente().setPrestiti(null);
        return pdto;
    }

    public List<PrestitoDTO> getAllPrestito() {
        List<PrestitoDTO> p=prestitoRepository.findAll().stream().map(PrestitoConverter::toDTO).toList();
        p.stream().forEach(pr->pr.getUtente().setPrestiti(null));
        return p;
    }
}

