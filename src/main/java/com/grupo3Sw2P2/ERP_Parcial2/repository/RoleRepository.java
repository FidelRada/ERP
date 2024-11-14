/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.repository;

import com.grupo3Sw2P2.ERP_Parcial2.models.Role;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author fidel
 */
public interface RoleRepository extends MongoRepository<Role, String>{
    Optional<Role> findByName(String name);
}
