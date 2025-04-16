package org.lesson.java.spring_la_mia_pizzeria_crud.controller;

import org.lesson.java.spring_la_mia_pizzeria_crud.model.Offerta;
import org.lesson.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lesson.java.spring_la_mia_pizzeria_crud.repository.OffertaRepository;
import org.lesson.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("offerta")
public class OffertaController {

    @Autowired
    private OffertaRepository repository;

 @PostMapping("/create")
    public String offertaSave(@Valid @ModelAttribute ("offerta") Offerta offertaForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "offerta/create-or-edit";}
            repository.save(offertaForm);
        
        return "redirect:/pizze";
    }
// creo le rotte per updare e edit delle offerte
@GetMapping("/edit/{id}")
public String edit(@PathVariable Integer id, Model model) {
    model.addAttribute("offerta", repository.findById(id).get());
    model.addAttribute("edit", true);
    return "offerta/create-or-edit";
}

@PostMapping("/edit/{id}")
public String updateOfferta (@Valid @ModelAttribute("offerta") Offerta offertaForm, BindingResult bindingResult, Model model  ){
    if(bindingResult.hasErrors()){
        return "offerta/create-or-edit";}
        repository.save(offertaForm);
        return "redirect:/pizze";
}
}




    

