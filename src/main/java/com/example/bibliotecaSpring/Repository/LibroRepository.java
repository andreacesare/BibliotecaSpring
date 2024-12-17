package com.example.bibliotecaSpring.Repository;

import com.example.bibliotecaSpring.DTO.PrestitoDTO;
import com.example.bibliotecaSpring.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {




}
