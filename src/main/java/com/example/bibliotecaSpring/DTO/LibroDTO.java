package com.example.bibliotecaSpring.DTO;

import com.example.bibliotecaSpring.Entity.Libro;
import com.example.bibliotecaSpring.Entity.Prestito;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibroDTO {

    private String idl;
    private String titolo;
    private String autore;
    private List<PrestitoDTO> prestiti;


    public String getIdl() {return idl;}
    public void setIdl(String idl) {this.idl = idl;}
    public String getTitolo() {return titolo;}
    public void setTitolo(String titolo) {this.titolo = titolo;}
    public String getAutore() {return autore;}
    public void setAutore(String autore) {this.autore = autore;}
    public String toString(){
        return idl+" "+titolo+" "+autore;
    }
    public List<PrestitoDTO> getPrestito() {return prestiti;}
    public void setPrestito(List<PrestitoDTO> prestiti) {
        this.prestiti = prestiti;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true; // Se sono lo stesso oggetto, sono uguali
        if (obj == null || getClass() != obj.getClass()) return false; // Se sono di tipo diverso, non sono uguali
        LibroDTO libro = (LibroDTO) obj; // Cast dell'oggetto
        return idl.equals(libro.idl)&&titolo.equals(libro.titolo) && autore.equals(libro.autore); // Confronta i campi principali
    }

    public int hashCode() {
        return Objects.hash(idl,titolo, autore);
    }
}
