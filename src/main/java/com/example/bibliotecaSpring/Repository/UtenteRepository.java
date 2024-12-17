package com.example.bibliotecaSpring.Repository;

import com.example.bibliotecaSpring.DTO.UtenteLibroDTO;
import com.example.bibliotecaSpring.Entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    @Query(value="select u.idu,u.nome,u.cognome,l.titolo from prestiti p join utenti u on p.idu=u.idu join libri l on p.idl=l.idl where fine is null", nativeQuery=true)
    public List<Object[]> libriNonRientrati();

    @Query(value="select l.titolo,l.autore,p.inizio,p.fine from prestiti p join libri l on p.idl=l.idl join utenti u on u.idu=p.idu where u.idu=:idu", nativeQuery=true)
    public List<Object[]> libriUtente(@Param("idu") Integer idu);
}
