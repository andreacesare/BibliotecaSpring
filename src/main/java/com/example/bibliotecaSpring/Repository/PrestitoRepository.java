package com.example.bibliotecaSpring.Repository;

import com.example.bibliotecaSpring.Entity.Prestito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Integer> {
}
