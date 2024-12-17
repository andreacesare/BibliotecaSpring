package com.example.bibliotecaSpring.DTO;

import com.example.bibliotecaSpring.Entity.Libro;
import com.example.bibliotecaSpring.Entity.Utente;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.time.LocalDate;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrestitoDTO {

    private int idp;
    private LocalDate inizio;
    private LocalDate fine;
    private LibroDTO libro;
    private UtenteDTO utente;

    public PrestitoDTO() {}

    public PrestitoDTO(String nome,String cognome,String titolo){
        UtenteDTO utente = new UtenteDTO();
        LibroDTO libro = new LibroDTO();
        this.utente.setNome(nome);
        this.utente.setCognome(cognome);
        this.libro.setTitolo(titolo);
    }

    public int getIdp(){return idp;}
    public void setIdp(int idp){this.idp = idp;}
    public LocalDate getInizio(){return inizio;}
    public void setInizio(LocalDate inizio){this.inizio = inizio;}
    public LocalDate getFine(){return fine;}
    public void setFine(LocalDate fine){this.fine = fine;}
    public LibroDTO getLibro(){return libro;}
    public void setLibro(LibroDTO libro){this.libro = libro;}
    public UtenteDTO getUtente(){return utente;}
    public void setUtente(UtenteDTO utente){this.utente = utente;}
    public String toString(){
        return idp+"\t Libro:"+getLibro().getTitolo()+"\t"+getLibro().getAutore()+"\t Utente:"+getUtente().getNome()+"\t"+getUtente().getCognome()+"\t Inizio:"+getInizio()+"\t Fine:"+getFine();
    }
}
