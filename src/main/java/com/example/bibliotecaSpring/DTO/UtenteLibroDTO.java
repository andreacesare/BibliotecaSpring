package com.example.bibliotecaSpring.DTO;

import java.sql.Date;

public class UtenteLibroDTO {
    private Integer idu;
    private String nome;
    private String cognome;
    private String libro;


    public UtenteLibroDTO() {}

    public UtenteLibroDTO(Integer idu, String nome, String cognome, String titolo) {
        this.idu = idu;
        this.nome = nome;
        this.cognome = cognome;
        this.libro = titolo;
    }

    public Integer getIdu() {
        return idu;
    }
    public void setIdu(Integer idu) {
        this.idu = idu;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getLibro() {
        return libro;
    }
    public void setLibro(String libro) {
        this.libro = libro;
    }

}
