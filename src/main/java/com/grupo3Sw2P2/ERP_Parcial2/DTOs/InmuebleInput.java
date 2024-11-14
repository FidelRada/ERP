/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.DTOs;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fidel
 */
@Setter
@Getter
public class InmuebleInput {

    private String direccion;
    private String tipo;
    private Double superficie;
    private Double valor;
    private String descripcion;
    private String personaId;
}
