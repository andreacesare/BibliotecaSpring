package com.example.bibliotecaSpring.DTO;

import com.example.bibliotecaSpring.Entity.Prestito;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtenteDTO {

    private int idu;
    private String nome;
    private String cognome;
    private List<PrestitoDTO> prestiti=new ArrayList<>();

    public int getIdu() {return idu;}
    public void setIdu(int idu) {this.idu = idu;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}
    public List<PrestitoDTO> getPrestiti() {return prestiti;}
    public void setPrestiti(List<PrestitoDTO> prestiti) {
        this.prestiti = prestiti;
    }
    public String toString() {
        return idu + "\t" + nome + "\t" + cognome;
    }
}
