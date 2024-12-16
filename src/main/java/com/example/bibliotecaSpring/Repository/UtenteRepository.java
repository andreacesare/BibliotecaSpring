package com.example.bibliotecaSpring.Repository;

import com.example.bibliotecaSpring.Entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
}
