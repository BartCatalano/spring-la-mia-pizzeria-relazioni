package org.lesson.java.spring_la_mia_pizzeria_crud.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// imposto come entity
@Entity
public class Pizza {
// creo la relazione one to many per la tabella delle offerte
@OneToMany(mappedBy = "pizza")
private List<Offerta> offerte;


    // creo le var d istanza delle pizza, in questo caso sono le colonne della tabella
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "inserire il nome della pizza")
    private String name;
    @NotBlank(message = "Inserire almeno un ingrediente")
    private String descrizione;

    private String foto;

    @NotNull(message = "inserire prezzo della pizza")
    private BigDecimal prezzo; 

// creo getter e setter


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public BigDecimal getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString(){
        return String.format( "%s:  %s: Prezzo: €%.2f", this.name, this.descrizione, this.prezzo);
    }
    
}