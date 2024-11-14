/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.controllerGraphQL;

import com.grupo3Sw2P2.ERP_Parcial2.models.Role;
import com.grupo3Sw2P2.ERP_Parcial2.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fidel
 */
@Controller
public class RoleGraphQLController {
    @Autowired
    private RoleRepository roleRepository;
    
    //@PreAuthorize("hasrole('ROLE_ADMIN')")
    @QueryMapping
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @QueryMapping
    public Role getRoleById(@Argument String id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

}
