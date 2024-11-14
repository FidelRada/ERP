/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.controllerGraphQL;

import com.grupo3Sw2P2.ERP_Parcial2.DTOs.InmuebleInput;
import com.grupo3Sw2P2.ERP_Parcial2.models.Inmueble;
import com.grupo3Sw2P2.ERP_Parcial2.services.InmuebleService;
import com.grupo3Sw2P2.ERP_Parcial2.services.PersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fidel
 */
@Controller
public class InmuebleGraphQLController {

    @Autowired
    private InmuebleService inmuebleService;

    @Autowired
    private PersonaService personaService;

    @QueryMapping
    public List<Inmueble> getAllInmuebles() {
        return inmuebleService.getAllInmuebles();
    }

    @QueryMapping
    public Inmueble getInmuebleById(@Argument String id) {
        return inmuebleService.getInmuebleById(id).orElse(null);
    }

    @MutationMapping
    public Inmueble createInmueble(@Argument InmuebleInput input) {
        
        System.out.println(input);
        if (input == null) {
            return null;
        }

        Inmueble inmueble = new Inmueble();
        inmueble.setDireccion(input.getDireccion());
        inmueble.setTipo(input.getTipo());
        inmueble.setSuperficie(input.getSuperficie());
        inmueble.setValor(input.getValor());
        inmueble.setDescripcion(input.getDescripcion());

        if (input.getPersonaId() != null) {
            personaService.obtenerPorId(input.getPersonaId()).ifPresent(inmueble::setPersona);
        }

        return inmuebleService.saveInmueble(inmueble);
    }

    @MutationMapping
    public Inmueble updateInmueble(@Argument String id, @Argument InmuebleInput input) {

        Optional<Inmueble> optionalInmueble = inmuebleService.getInmuebleById(id);
        if (optionalInmueble.isEmpty()) {
            return null;
        }

        Inmueble inmueble = optionalInmueble.get();

        inmueble.setDescripcion(input.getDescripcion());
        inmueble.setDireccion(input.getDireccion());
        inmueble.setSuperficie(input.getSuperficie());
        inmueble.setTipo(input.getTipo());
        inmueble.setValor(input.getValor());

        personaService.obtenerPorId(input.getPersonaId()).ifPresentOrElse(inmueble::setPersona, null);

        if (inmueble.getPersona() == null) {
            return null;
        }

        return inmuebleService.updateInmueble(id, inmueble);
    }

    @MutationMapping
    public Boolean deleteInmueble(@Argument String id) {
        Optional<Inmueble> optionalInmueble = inmuebleService.getInmuebleById(id);
        if (optionalInmueble.isPresent()) {
            inmuebleService.deleteInmueble(id);
            return true;
        }
        return false;
    }

}
