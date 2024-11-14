/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.responses;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fidel
 * @param <T>
 */
@Setter
@Getter
public class Response<T> {
    private T data;
    private int codigoRes;
    private String mensaje;
}

