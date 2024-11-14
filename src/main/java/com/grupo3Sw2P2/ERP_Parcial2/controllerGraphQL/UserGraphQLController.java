/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.controllerGraphQL;

import com.grupo3Sw2P2.ERP_Parcial2.DTOs.PersonaInput;
import com.grupo3Sw2P2.ERP_Parcial2.DTOs.UserInput;
import com.grupo3Sw2P2.ERP_Parcial2.models.Persona;
import com.grupo3Sw2P2.ERP_Parcial2.models.Role;
import com.grupo3Sw2P2.ERP_Parcial2.models.User;
import com.grupo3Sw2P2.ERP_Parcial2.repository.PersonaRepository;
import com.grupo3Sw2P2.ERP_Parcial2.repository.RoleRepository;
import com.grupo3Sw2P2.ERP_Parcial2.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fidel
 */

@Controller
public class UserGraphQLController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @QueryMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @QueryMapping
    public User getUserById(@Argument String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @MutationMapping
    public User createUser(@Argument UserInput input) {
        Persona persona = personaRepository.findById(input.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        List<Role> roles = roleRepository.findAllById(input.getRoleIds());

        User user = new User();
        user.setUsername(input.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(input.getPassword()));
        user.setPersona(persona);
        user.setRoles(roles);

        return userRepository.save(user);
    }
    
    @MutationMapping
    public User updateUser(@Argument String id, @Argument UserInput input) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Persona persona = personaRepository.findById(input.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        List<Role> roles = roleRepository.findAllById(input.getRoleIds());

        existingUser.setUsername(input.getUsername());
        existingUser.setPassword(new BCryptPasswordEncoder().encode(input.getPassword()));
        existingUser.setPersona(persona);
        existingUser.setRoles(roles);

        return userRepository.save(existingUser);
    }

    @MutationMapping
    public String deleteUser(@Argument String id) {
        userRepository.deleteById(id);
        return "Usuario eliminado con éxito";
    }
}
