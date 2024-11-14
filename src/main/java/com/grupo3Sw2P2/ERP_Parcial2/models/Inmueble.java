/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author fidel
 */
@Setter
@Getter
@Document
public class Inmueble {
    @Id
    private String id;
    private String direccion;
    private String tipo; //'Casa', 'Departamento', 'Terreno'
    private Double superficie; //NUMERIC(10, 2), -- En metros cuadrados
    private Double valor; //NUMERIC(15, 2), -- Valor estimado en moneda local
    private String descripcion;
    
    @DBRef(lazy = false)
    private Persona persona;
}
