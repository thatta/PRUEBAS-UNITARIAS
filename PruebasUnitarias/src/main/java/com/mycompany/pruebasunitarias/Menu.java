/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasunitarias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Menu {

    public HashMap<Integer, Persona> mapaAbuelo;

    public void Menu() {

        quemarMapa();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el codigo que desea buscar:");
        int codigo = sc.nextInt();
        buscar(codigo);
    }

    private void quemarMapa() {
        
        mapaAbuelo = new HashMap<>();
        mapaAbuelo.put(1, new Persona(1, "Juan"));
        mapaAbuelo.put(2, new Persona(2, "Jose"));
        mapaAbuelo.get(1).getDatos().put(3, new Persona(3, "Andres"));
        mapaAbuelo.get(1).getDatos().put(4, new Persona(4, "Maria"));
        mapaAbuelo.get(1).getDatos().put(5, new Persona(5, "Carlos"));
        mapaAbuelo.get(2).getDatos().put(6, new Persona(6, "Alberto"));
        mapaAbuelo.get(2).getDatos().put(7, new Persona(7, "Jimmy"));
        mapaAbuelo.get(2).getDatos().put(8, new Persona(8, "Jhon"));
        mapaAbuelo.get(1).getDatos().get(3).getDatos().put(9, new Persona(9, "Juana"));
        mapaAbuelo.get(1).getDatos().get(3).getDatos().put(10, new Persona(10, "Paola"));
        mapaAbuelo.get(1).getDatos().get(4).getDatos().put(11, new Persona(11, "Sofia"));
        mapaAbuelo.get(1).getDatos().get(5).getDatos().put(12, new Persona(12, "Jaime"));
        mapaAbuelo.get(2).getDatos().get(6).getDatos().put(13, new Persona(13, "Tatiana"));
        mapaAbuelo.get(2).getDatos().get(6).getDatos().put(14, new Persona(14, "Fernanda"));
        mapaAbuelo.get(2).getDatos().get(7).getDatos().put(15, new Persona(15, "Viviana"));
        mapaAbuelo.get(2).getDatos().get(8).getDatos().put(16, new Persona(16, "Diana"));
        
    }

    public String buscar(int codigo) {
        
        quemarMapa();
        String total = "";
        ArrayList<String> string2= new ArrayList<String>();
        ArrayList<String> string3= new ArrayList<String>();
        ArrayList<String> string6= new ArrayList<String>();
        String parte1 = "";
        String parte2 = "";
        String parte3 = "";
        String parte4 = "";
        String parte5 = "";
        String parte6 = "";
        if (mapaAbuelo.containsKey(codigo)) {
            System.out.println("Abuelo: " + mapaAbuelo.get(codigo).getNombre() + "\nPadres :");
            parte1 = mapaAbuelo.get(codigo).getNombre();    
            Iterator it = mapaAbuelo.get(codigo).getDatos().keySet().iterator();
            while (it.hasNext()) {
                int i = Integer.parseInt(it.next().toString());
                System.out.println(mapaAbuelo.get(codigo).getDatos().get(i).getNombre());
                string2.add(mapaAbuelo.get(codigo).getDatos().get(i).getNombre());
                System.out.println("Nietos: ");
                Iterator itera = mapaAbuelo.get(codigo).getDatos().get(i).getDatos().keySet().iterator();
                while (itera.hasNext()) {
                    int j = Integer.parseInt(itera.next().toString());
                    System.out.println(mapaAbuelo.get(codigo).getDatos().get(i).getDatos().get(j).getNombre());
                    string3.add(mapaAbuelo.get(codigo).getDatos().get(i).getDatos().get(j).getNombre());
                }
            }
            for(int a=0;a<string2.size();a++){
                parte2= parte2+" "+string2.get(a);
            }
            for(int b=0;b<string3.size();b++){
                parte3= parte3+" "+string3.get(b);
            }
            total = parte1+parte2+parte3;
        } 
        else {
            Iterator it = mapaAbuelo.keySet().iterator();
            while (it.hasNext()) {
                int i = Integer.parseInt(it.next().toString());
                if (mapaAbuelo.get(i).getDatos().containsKey(codigo)) {
                    System.out.println("Padre: " + mapaAbuelo.get(i).getDatos().get(codigo).getNombre() + " Abuelo : "
                            + mapaAbuelo.get(i).getNombre() + " Hijos: ");
                    parte4 = mapaAbuelo.get(i).getDatos().get(codigo).getNombre();
                    parte5 = mapaAbuelo.get(i).getNombre();
                    Iterator itera = mapaAbuelo.get(i).getDatos().get(codigo).getDatos().keySet().iterator();

                    while (itera.hasNext()) {
                        int j = Integer.parseInt(itera.next().toString());
                        System.out.println(mapaAbuelo.get(i).getDatos().get(codigo).getDatos().get(j).getNombre());
                        string6.add(mapaAbuelo.get(i).getDatos().get(codigo).getDatos().get(j).getNombre());
                    }
                    for(int a=0;a<string6.size();a++){
                        parte6= parte6+" "+string6.get(a);
                    }
                    
                    total = parte4+" "+parte5+parte6;
                } 
                else {
                    Iterator itera = mapaAbuelo.get(i).getDatos().keySet().iterator();
                    while (itera.hasNext()) {
                        int j = Integer.parseInt(itera.next().toString());
                        if (mapaAbuelo.get(i).getDatos().get(j).getDatos().containsKey(codigo)) {
                            System.out.println("Hijo " + mapaAbuelo.get(i).getDatos().get(j).getDatos().get(codigo).getNombre() 
                                    + " Padre" + mapaAbuelo.get(i).getDatos().get(j).getNombre() + "\n Abuelo: " + mapaAbuelo.get(i).getNombre());
                            total = mapaAbuelo.get(i).getDatos().get(j).getDatos().get(codigo).getNombre() + " " + mapaAbuelo.get(i).getDatos().get(j).getNombre() + " " + mapaAbuelo.get(i).getNombre();
                            
                        }
                    }
                }
            }
        }
        System.out.println(total);
        return total;
    }

}
