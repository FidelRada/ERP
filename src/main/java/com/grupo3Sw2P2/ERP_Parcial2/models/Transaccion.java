/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author fidel
 */
@Setter
@Getter
@Document
public class Transaccion {
    private String id;
    private String tipo; // VARCHAR(50) NOT NULL, -- 'Compra', 'Venta', 'Herencia'
    private Date fecha;// DATE NOT NULL,
    private Double monto;// NUMERIC(15, 2) NOT NULL,
//    private  comprador_id UUID REFERENCES users(id),
//    vendedor_id UUID REFERENCES users(id),
//    inmueble_id UUID REFERENCES Inmueble(id),
//    detalles TEXT
}
