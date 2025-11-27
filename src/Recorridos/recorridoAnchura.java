package Recorridos;

import Clases.Grafo;
import java.util.LinkedList;
import java.util.Queue;;

/**
 *
 * @author diego jaimes escobar
 */
public class recorridoAnchura {
    //como podria comenzar......
    // ya se :D
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
        
        System.out.print("Recorrido de Anchura desde " + ori + ":\n ");
        int actual;
        while (!cola.isEmpty()) {
            actual = cola.poll();
            System.out.print(grafo.getVertice(actual).getNombre() + " ");
            
            for (int w = 0; w < grafo.verticesT(); w++) {
                if (grafo.aristaE(actual, w) && !visitarr[w]) {
                    visitarr[w] = true;
                    cola.add(w);
                }
            }
        }
        System.out.println();
    }
}
