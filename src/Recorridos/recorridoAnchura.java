/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recorridos;

import Clases.Arista;
import Clases.Grafo;
import java.util.LinkedList;
import java.util.Queue;;

/**
 *
 * @author diego123
 */
public class recorridoAnchura {

    public static boolean recorridoAnchura(Grafo grafo, String ini, String obj) {
        int indiceI = grafo.buscar(ini);
        int indiceO = grafo.buscar(obj);
        if (indiceI == -1 || indiceO == -1) {
            System.out.println("El vértice no existe");
            return false;
        }
        
        Queue<Integer> cola = new LinkedList<>();
        boolean[] visitarN = new boolean[grafo.verticesT()];
        
        visitarN[indiceI] = true;
        cola.add(indiceI);
        int actual; 
        while(!cola.isEmpty()){
            actual = cola.poll();
            
            if(actual == indiceO){
                System.out.println("Encontrado " + obj);
                return true;
            }
            for (int w = 0; w < grafo.verticesT(); w++) {
                if (grafo.aristaE(actual, w) && !visitarN[w]){
                    visitarN[w] = true;
                    cola.add(w);
                }
            }
        }
        System.out.println(obj + " No encontrado");
        return false;
    }
    
    public static void recorresAnchura(Grafo grafo, String ori) {
        int indiceO = grafo.buscar(ori);
        if (indiceO == -1) {
            System.out.println("El vertice " + ori + " no existe");
            return;
        }
        
        Queue<Integer> cola = new LinkedList<>();
        boolean[] visitarr = new boolean[grafo.verticesT()];
        
        visitarr[indiceO] = true;
        cola.add(indiceO);
        
        System.out.print("BFS desde " + ori + ": ");
        
        while (!cola.isEmpty()) {
            int nodoActual = cola.poll();
            System.out.print(grafo.getVertice(nodoActual).getNombre() + " ");
            
            for (int w = 0; w < grafo.verticesT(); w++) {
                if (grafo.aristaE(nodoActual, w) && !visitarr[w]) {
                    visitarr[w] = true;
                    cola.add(w);
                }
            }
        }
        System.out.println();
    }
}
