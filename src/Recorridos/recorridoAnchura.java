/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recorridos;
import Clases.Arista;
import Clases.Grafo;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author diego123
 */
public class recorridoAnchura {
    private Grafo grafo;
    int actual, dest;
    public recorridoAnchura(Grafo grafo){
        this.grafo = grafo;
    }
    
    public void recorrer(String nombre){
        int iniciar = grafo.BuscarVerIndice(nombre);
        
        if (iniciar == -1){
            System.out.println("Vertice no encontrado o inexistente");
            return;
        }
        
        boolean[] visitado = new boolean[grafo.getNumVertice()];
        Queue<Integer> cola = new LinkedList<>();
        
        visitado[iniciar] = true;
        cola.add(iniciar);
        
        while(!cola.isEmpty()){
            actual = cola.remove();
            System.out.println(grafo.getVertice(actual).getNombre());
            for (Arista a : grafo.getAdyacentes(actual)) {
                dest = a.getDes().getNumVertice();
                
                if(!visitado[dest]){
                    visitado[dest] = true;
                    cola.add(dest);
                }  
            }
        }
    }
}
