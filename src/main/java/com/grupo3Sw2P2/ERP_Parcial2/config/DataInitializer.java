/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.config;

import com.grupo3Sw2P2.ERP_Parcial2.models.Persona;
import com.grupo3Sw2P2.ERP_Parcial2.models.Role;
import com.grupo3Sw2P2.ERP_Parcial2.models.User;
import com.grupo3Sw2P2.ERP_Parcial2.repository.PersonaRepository;
import com.grupo3Sw2P2.ERP_Parcial2.repository.RoleRepository;
import com.grupo3Sw2P2.ERP_Parcial2.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author fidel
 */
@Configuration
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository; // Asegúrate de tener un repositorio para Role

    @Autowired
    private PersonaRepository PersonaRepository;

    @Bean
    public CommandLineRunner initData(PasswordEncoder passwordEncoder) {
        return args -> {
            // Verificar si el rol "Admin" ya existe, si no, crearlo
            if (roleRepository.findByName("ADMIN").isEmpty()) {
                Role adminRole = new Role();
                adminRole.setName("ADMIN");
                roleRepository.save(adminRole);
            }

            // Verificar si la persona "admin" ya existe, si no, crearlo
            if (PersonaRepository.findByNombre("admin").isEmpty()) {
                Persona personaAdmin = new Persona();
                personaAdmin.setNombre("admin");
                personaAdmin.setApellidoPaterno("admin"); // Codificar la contraseña
                personaAdmin.setApellidoMaterno("admin");
                personaAdmin.setCi("0000000000");
                PersonaRepository.save(personaAdmin);
            }

            // Verificar si el usuario "admin" ya existe, si no, crearlo
            if (userRepository.findByUsername("admin").isEmpty()) {
                
                Optional<Persona> PersonaExitente =  PersonaRepository.findByNombre("admin");
                System.out.println(PersonaExitente.get().toString());
                
                Persona personaAdmin = PersonaExitente.get();
                User adminUser = new User();
                adminUser.setUsername("admin");
                adminUser.setPassword(passwordEncoder.encode("admin123")); // Codificar la contraseña
                adminUser.setRoles(List.of(roleRepository.findByName("ADMIN").get()));
                adminUser.setPersona(personaAdmin);
                userRepository.save(adminUser);
            }
        };
    }
}
