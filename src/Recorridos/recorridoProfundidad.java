/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recorridos;
import Clases.Grafo;

import java.util.Stack;
/**
 *
 * @author diego123
 */
public class recorridoProfundidad {
    public static boolean recorridoProfundidad(Grafo grafo, String ini, String obj){
        int indiceI = grafo.buscar(ini);
        int indiceO = grafo.buscar(obj);
        if (indiceI == -1 || indiceO == -1) {
            System.out.println("El vértice no existe");
            return false;
        }
        Stack<Integer> pila = new Stack<>();
        boolean[] visitarN = new boolean[grafo.verticesT()];
        
        pila.push(indiceI);
        visitarN[indiceO] = true;
        
        int actual;
        while(!pila.isEmpty()){
            actual = pila.pop();
            
            if(actual == indiceO){
                System.out.println("Encontrado " + obj);
                return true;
            }
            
            for (int w = 0; w < grafo.verticesT(); w++) {
                if(grafo.aristaE(actual, w) && !visitarN[w]){
                    pila.push(w);
                    visitarN[w] = true;
                }  
            }
        }
        System.out.println(obj + " No encontrado");
        return false;
    }
    
    public static void recorresProfundidad(Grafo grafo, String ori){
        int indiceO = grafo.buscar(ori);
        
        if(indiceO == -1){
            System.out.println("Vertice " + ori + " no existe");
            return;
        }
        
        Stack<Integer> pila = new Stack<>();
        boolean[] visitarN = new boolean[grafo.verticesT()];
        
        pila.push(indiceO);
        visitarN[indiceO] = true;
        
        int actual;
        while(!pila.isEmpty()){
            actual = pila.pop();
            System.out.println(grafo.getVertice(actual).getNombre());
            
            for (int w = 0; w < grafo.verticesT(); w++) {
                if(grafo.aristaE(actual, w) && !visitarN[w]){
                    pila.push(w);
                    visitarN[w] = true;
                }
            }       
        }
        System.out.println();
    }
}
