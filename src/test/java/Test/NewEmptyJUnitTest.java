/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import com.mycompany.pruebasu.Menu;
import com.mycompany.pruebasu.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *@author  Karen tatiana Almansa Jimenez
 *@author Juan David Ojeda bernal
 */
public class NewEmptyJUnitTest {
    
    /**
     *mapa donde se guardarán la información quemada del arbol familiar
     */
    public static HashMap<Integer, Persona> mapaAbuelo;
    static Menu pp; 
    
    /**
     *metodo a ejecutar despues de correr el menú
     */
    @BeforeClass
    public  static void setUpClass() {
       pp = new Menu();
       quemar();
    }
    
    /**
     *metodo donde se ingresan los datos quemados
     */
    public static void quemar(){        
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
    
    /**
     *
     */
    @AfterClass
    public  static void tearDownClass() {
    }
    
    /**
     *metodo a testear la información esperada para el abuelo
     */
    @Test
    public void Abuelo(){
        
        String respuesta="";
        String menu = pp.buscar(1);
        int codigo = 1;
        ArrayList<String> string2= new ArrayList<>();
        ArrayList<String> string3= new ArrayList<>();
        String parte1;
        String parte2 = "";
        String parte3 = "";
        quemar();
        if (mapaAbuelo.containsKey(codigo)) {
            parte1 = mapaAbuelo.get(codigo).getNombre();    
            Iterator it = mapaAbuelo.get(codigo).getDatos().keySet().iterator();
            while (it.hasNext()) {
                int i = Integer.parseInt(it.next().toString());
                string2.add(mapaAbuelo.get(codigo).getDatos().get(i).getNombre());
                Iterator itera = mapaAbuelo.get(codigo).getDatos().get(i).getDatos().keySet().iterator();
                while (itera.hasNext()) {
                    int j = Integer.parseInt(itera.next().toString());
                    string3.add(mapaAbuelo.get(codigo).getDatos().get(i).getDatos().get(j).getNombre());
                }
            }
            for(int a=0;a<string2.size();a++){
                parte2= parte2+" "+string2.get(a);
            }
            for(int b=0;b<string3.size();b++){
                parte3= parte3+" "+string3.get(b);
            }
            respuesta = parte1+parte2+parte3;
        }
        assertEquals(respuesta,menu);
    }
    
    /**
     *metodo a testear la información esperada para el padre
     */
    @Test
    public void Padre(){
        String respuesta1="";
        String menu1 = pp.buscar(3);
        int codigo = 3;
        ArrayList<String> string6= new ArrayList<>();
        String parte4 ;
        String parte5 ;
        String parte6 = "";
        quemar();
        Iterator it = mapaAbuelo.keySet().iterator();
        while (it.hasNext()) {
            int i = Integer.parseInt(it.next().toString());
            if (mapaAbuelo.get(i).getDatos().containsKey(codigo)) {
                parte4 = mapaAbuelo.get(i).getDatos().get(codigo).getNombre();
                parte5 = mapaAbuelo.get(i).getNombre();
                Iterator itera = mapaAbuelo.get(i).getDatos().get(codigo).getDatos().keySet().iterator();
                while (itera.hasNext()) {
                    int j = Integer.parseInt(itera.next().toString());
                    string6.add(mapaAbuelo.get(i).getDatos().get(codigo).getDatos().get(j).getNombre());
                }
                for(int a=0;a<string6.size();a++){
                    parte6= parte6+" "+string6.get(a);
                }
                    
                    respuesta1 = parte4+" "+parte5+parte6;
            }
        }
        assertEquals(respuesta1, menu1);
    }
    
    /**
     *metodo a testear la información esperada para el hijo
     */
    @Test
    public void Hijo(){
        String respuesta2 = "";
        String menu2 = pp.buscar(9);
        int codigo = 9;
        quemar();
        Iterator it = mapaAbuelo.keySet().iterator();
        int i = Integer.parseInt(it.next().toString());
        Iterator itera = mapaAbuelo.get(i).getDatos().keySet().iterator();
        while (itera.hasNext()) {
            int j = Integer.parseInt(itera.next().toString());
            if (mapaAbuelo.get(i).getDatos().get(j).getDatos().containsKey(codigo)) {
                respuesta2 = mapaAbuelo.get(i).getDatos().get(j).getDatos().get(codigo).getNombre() + " " + mapaAbuelo.get(i).getDatos().get(j).getNombre() + " " + mapaAbuelo.get(i).getNombre();

            }
        }
        assertEquals(respuesta2, menu2);
    }
 
}
