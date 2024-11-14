/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author fidel
 */
@Setter
@Getter
@Document
public class Role implements GrantedAuthority {
    
    @Id
    private String id;
    private String name;

    // Constructor, getters y setters

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
