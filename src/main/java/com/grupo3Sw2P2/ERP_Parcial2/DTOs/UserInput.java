/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo3Sw2P2.ERP_Parcial2.DTOs;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fidel
 */
@Setter
@Getter
public class UserInput {
    private String username;
    private String password;
    private String personaId;
    private List<String> roleIds;
}
