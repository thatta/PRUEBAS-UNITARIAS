/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasu;

import java.util.HashMap;

/**
 *@author  Karen tatiana Almansa Jimenez
 *@author Juan David Ojeda bernal
 */
public class Persona {
    private int documento;
    private String nombre;
    private HashMap<Integer,Persona> datos;

    /**
     *constructor de la clase donde se van a guardar los datos de las personas en una variable
     * @param documento
     * @param nombre
     */
    public Persona(int documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
        datos = new HashMap<>();
    }

    /**
     *
     * @return
     */
    public int getDocumento() {
        return documento;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public HashMap<Integer, Persona> getDatos() {
        return datos;
    }
    
}
