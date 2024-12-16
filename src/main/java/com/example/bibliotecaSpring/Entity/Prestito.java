package com.example.bibliotecaSpring.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="prestiti")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idp;
    private LocalDate inizio;
    private LocalDate fine;
    @ManyToOne
    @JoinColumn(name="idl")
    private Libro libro;
    @ManyToOne
    @JoinColumn(name="idu")
    private Utente utente;

    public int getIdp(){return idp;}
    public void setIdp(int idp){this.idp = idp;}
    public LocalDate getInizio(){return inizio;}
    public void setInizio(LocalDate inizio){this.inizio = inizio;}
    public LocalDate getFine(){return fine;}
    public void setFine(LocalDate fine){this.fine = fine;}
    public Libro getLibro(){return libro;}
    public void setLibro(Libro libro){this.libro = libro;}
    public Utente getUtente(){return utente;}
    public void setUtente(Utente utente){this.utente = utente;}
    public String toString(){
        return idp+"\t Libro:"+getLibro().getTitolo()+"\t"+getLibro().getAutore()+"\t Utente:"+getUtente().getNome()+"\t"+getUtente().getCognome()+"\t Inizio:"+getInizio()+"\t Fine:"+getFine();
    }
}
