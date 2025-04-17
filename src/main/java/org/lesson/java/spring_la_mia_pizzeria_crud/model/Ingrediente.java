package org.lesson.java.spring_la_mia_pizzeria_crud.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ingrediente {

    @ManyToMany(mappedBy = "ingredienti")
    private List<Pizza> pizze;
     // creo le var d istanza delle pizza, in questo caso sono le colonne della tabella
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "inserire il nome ingrediente")
    private String nameIngrediente;
}
