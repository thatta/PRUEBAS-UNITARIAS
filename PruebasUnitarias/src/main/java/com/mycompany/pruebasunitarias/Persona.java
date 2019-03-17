/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasunitarias;

import java.util.HashMap;

/**
 *
 * @author Diego
 */
public class Persona {
    private int documento;
    private String nombre;
    private HashMap<Integer,Persona> datos;

    public Persona(int documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
        datos = new HashMap<>();
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<Integer, Persona> getDatos() {
        return datos;
    }
    
}
