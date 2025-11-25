package Recorridos;
import Clases.Grafo;
import java.util.Stack;
/**
 *
 * @author diego jaimes escobar
 */
public class recorridoProfundidad {
    //verificar si y solo si existe un camino para los vertices
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
        visitarN[indiceI] = true;
        
        int actual;
        while(!pila.isEmpty()){
            actual = pila.pop();
            
            if(actual == indiceO){
                System.out.println("Encontrado " + obj);
                return true;
            }
            for (int w = grafo.verticesT() - 1; w >= 0; w--){
            //for (int w = 0; w < grafo.verticesT(); w++) {
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
        
        System.out.print("Recorrido de Profundidad desde " + ori + ":\n ");
        int actual;
        while(!pila.isEmpty()){
            actual = pila.pop();
            System.out.print(grafo.getVertice(actual).getNombre() + " ");
            for (int w = grafo.verticesT() - 1; w >= 0; w--){
            //for (int w = 0; w < grafo.verticesT(); w++) {
                if(grafo.aristaE(actual, w) && !visitarN[w]){
                    pila.push(w);
                    visitarN[w] = true;
                }
            }       
        }
        System.out.println();
    }
}
