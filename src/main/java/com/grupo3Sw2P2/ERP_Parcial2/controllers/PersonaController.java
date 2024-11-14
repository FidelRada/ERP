/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.controllers;

import com.grupo3Sw2P2.ERP_Parcial2.models.Persona;
import com.grupo3Sw2P2.ERP_Parcial2.services.PersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fidel
 */

//@RestController
//@RequestMapping("/api/personas")
public class PersonaController {
//
//    @Autowired
//    private PersonaService personaService;
//
//    @GetMapping
//    public List<Persona> obtenerTodas() {
//        return personaService.obtenerTodas();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Persona> obtenerPorId(@PathVariable String id) {
//        return personaService.obtenerPorId(id);
//    }
//
//    @PostMapping
//    public Persona guardar(@RequestBody Persona persona) {
//        return personaService.guardar(persona);
//    }
//    
//    @PutMapping("/{id}")
//    public Persona actualizar(@PathVariable String id, @RequestBody Persona persona){
//        return personaService.actualizar(id, persona);
//    }
//
//    @DeleteMapping("/{id}")
//    public void eliminar(@PathVariable String id) {
//        personaService.eliminar(id);
//    }
}