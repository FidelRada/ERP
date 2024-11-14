/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author fidel
 */
@Setter
@Getter
@Document
public class User implements UserDetails {

    @Id
    private String id;
    private String username;
    private String password;

    @DBRef(lazy = false)
    private Persona persona;  // Relación con la entidad Persona

    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }
    
    /*
    @Override
    public boolean isAccountNonExpired() {
        return true; // Cambiar si necesitas lógica específica
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Cambiar si necesitas lógica específica
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Cambiar si necesitas lógica específica
    }

    @Override
    public boolean isEnabled() {
        return true; // Cambiar si necesitas lógica específica
    }
    */

}
