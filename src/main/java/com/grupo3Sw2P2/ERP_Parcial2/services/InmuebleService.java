/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.services;

import com.grupo3Sw2P2.ERP_Parcial2.models.Inmueble;
import com.grupo3Sw2P2.ERP_Parcial2.repository.InmuebleRepository;
import com.grupo3Sw2P2.ERP_Parcial2.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fidel
 */
@Service
public class InmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;
    
    @Autowired
    private PersonaRepository personaRepository;
    
    public List<Inmueble> getAllInmuebles() {
        return inmuebleRepository.findAll();
    }

    public Optional<Inmueble> getInmuebleById(String id) {
        return inmuebleRepository.findById(id);
    }

    public Inmueble saveInmueble(Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }
   
    public Inmueble updateInmueble(String id, Inmueble inmuebleNuevo){
        
        Optional<Inmueble> inmuebleExiste = inmuebleRepository.findById(id);
        
        if (!inmuebleExiste.isPresent()) {
            throw new RuntimeException("Persona no encontrada con id: " + id);
        }
        
        Inmueble inmueble = inmuebleExiste.get();
        
        inmueble.setDescripcion(inmuebleNuevo.getDescripcion());
        inmueble.setDireccion(inmuebleNuevo.getDireccion());
        inmueble.setSuperficie(inmuebleNuevo.getSuperficie());
        inmueble.setTipo(inmuebleNuevo.getTipo());
        inmueble.setValor(inmuebleNuevo.getValor());
        inmueble.setPersona(inmuebleNuevo.getPersona());
         
        return inmuebleRepository.save(inmueble);
    }

    public void deleteInmueble(String id) {
        inmuebleRepository.deleteById(id);
    }

}
