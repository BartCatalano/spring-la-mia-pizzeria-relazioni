package org.lesson.java.spring_la_mia_pizzeria_crud.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Offerta {

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

     // creo le var d istanza delle pizza, in questo caso sono le colonne della tabella
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull (message = "inserire data di inizio")
    @PastOrPresent(message = "inserire una data valida di inizio offerta")
    private LocalDate inizioOfferta;
    @NotNull (message = "inserire data di fine")
    @PastOrPresent(message = "inserire una data valida di fine offerta")
    private LocalDate fineOfferta;
    @NotBlank (message = "inserire Nome Offerta")
    private String nomeOfferta;
    
}
