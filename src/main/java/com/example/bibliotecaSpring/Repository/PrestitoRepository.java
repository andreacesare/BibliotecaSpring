package com.example.bibliotecaSpring.Repository;

import com.example.bibliotecaSpring.Entity.Libro;
import com.example.bibliotecaSpring.Entity.Prestito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Integer> {


}
