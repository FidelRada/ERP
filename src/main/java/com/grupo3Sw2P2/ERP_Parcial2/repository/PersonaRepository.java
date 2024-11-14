/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.repository;

import com.grupo3Sw2P2.ERP_Parcial2.models.Persona;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fidel
 */
@Repository
public interface PersonaRepository extends MongoRepository<Persona, String>{
     Optional<Persona> findByNombre(String nombre);
    
}
