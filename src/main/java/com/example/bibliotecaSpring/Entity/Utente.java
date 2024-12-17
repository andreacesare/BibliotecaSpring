package com.example.bibliotecaSpring.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idu;
    private String nome;
    private String cognome;
    @OneToMany(mappedBy = "utente",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Prestito> prestiti;

    public Integer getIdu() {return idu;}
    public void setIdu(int idu) {this.idu = idu;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}
    public List<Prestito> getPrestiti() {return prestiti;}
    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }
    public String toString() {
        return idu + "\t" + nome + "\t" + cognome;
    }
}
