package com.example.bibliotecaSpring.Repository;

import com.example.bibliotecaSpring.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {
}
