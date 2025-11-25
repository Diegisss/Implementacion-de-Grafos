/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;
import Recorridos.recorridoAnchura;
import Clases.Grafo;
/**
 *
 * @author diego123
 */
public class TestRecorridoAnchura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo g = new Grafo();
        
        //agregamos nuestros vertices
        g.AgregarVertice("A");
        g.AgregarVertice("B");
        g.AgregarVertice("C");
        g.AgregarVertice("D");
        g.AgregarVertice("H");
        g.AgregarVertice("R");
        g.AgregarVertice("T");
        
        //agregamos aristas a los vertices
        g.AgregarArista("D", "B");
        g.AgregarArista("D", "C");
        g.AgregarArista("B", "H");
        g.AgregarArista("C", "R");
        g.AgregarArista("R", "H");
        g.AgregarArista("H", "A");
        g.AgregarArista("H", "T");
        g.AgregarArista("H", "D");
        
        System.out.println("\nGRAFO COMPLETO");
        g.mostrar();
        
        System.out.println("\nRECORRIDO");
        recorridoAnchura.recorresAnchura(g, "D");
    }
    
}
