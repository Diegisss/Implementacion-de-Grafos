
package Clases;

import java.util.ArrayList;

/**
 *
 * @author diego123
 */

public class Grafo {

    private ArrayList<Vertice> vertices;
    private int[][] matrizA;

    public Grafo() {
        vertices = new ArrayList<>();
    }

    public void AgregarVertice(String nombre) {
        if (buscar(nombre) != -1) {
            System.out.println("El vertice " + nombre + " existe");
            return;
        }
        Vertice nuevo = new Vertice(nombre);
        nuevo.asignarVertice(vertices.size()); //se asigna un numero de acuerdo a la posicion de este
        vertices.add(nuevo); //y lo agrega a mi lista
        int nuevoT = vertices.size(); //se crea el nuevo tamaño de acuerdo a la posicion
        int[][] nuevaM = new int[nuevoT][nuevoT];

        if (matrizA != null) { //si ya existe una matriz se reescriben los datos
            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA[i].length; j++) {
                    nuevaM[i][j] = matrizA[i][j];
                }
            }
        }
        matrizA = nuevaM; //reemplazamos

        System.out.println("Vértice " + nombre + " agregado");
    }

    public void eliminarVertice(String nombre) {
        int secuenciaI = buscar(nombre); //buscamos la posicion
        if (secuenciaI == -1) {
            System.out.println("El vértice " + nombre + " no existe");
            return;
        }
        
        vertices.remove(secuenciaI); //Se elimina de la lista el vertice

        //quiero aclarar que se crea o se hace un refresh de la nueva matriz solo que mas pequeña
        int tamaño = vertices.size();
        int[][] nuevaMatriz = new int[tamaño][tamaño];

        int nuevaF = 0;
        for (int i = 0; i < tamaño + 1; i++) { //recorremos filas de la anterior matriz
            if (i == secuenciaI) { //si es la fila del V eliminado
                continue; // Saltamos la fila eliminada
            }
            int nuevaC = 0;
            for (int j = 0; j < tamaño + 1; j++) {
                if (j == secuenciaI) { //si es la columna del V eliminado
                    continue; // Saltamos la columna eliminada
                }
                //Simplemente copiamos el valor de la vieja a la nueva
                if (i < matrizA.length && j < matrizA.length) {
                    nuevaMatriz[nuevaF][nuevaC] = matrizA[i][j];
                }
                nuevaC++;//seguimos a la siguiente columna
            }
            nuevaF++;//seguimos a la siguiente fila
        }
        matrizA = nuevaMatriz; //reescribimos

        // seccion donde se reasignan los vertices
        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).asignarVertice(i);
        }

        System.out.println("Vértice " + nombre + " eliminado");
    }

    public int buscar(String nombre) { //recorremos por todos los vertices en busca de el nombre
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getNombre().equals(nombre)) {
                return i; //regresa la posicion si lo encuentra
            }
        }
        return -1; //en caso contrario si no lo encuentra
    }

    public void AgregarArista(String origen, String des, int peso) {
        int ori = buscar(origen);
        int dest = buscar(des);

        if (ori == -1 || dest == -1) {
            System.out.println("El vertice no existe");
            return;
        }
        //simplemente agrega la arista en la matriz
        //dicho de otra manera ori es fila y dest es columna
        matrizA[ori][dest] = peso;
        System.out.println("Arista " + origen + " -> " + des + " agregada (peso: " + peso + ")");
    }

    public void EliminarArista(String origen, String des) {
        int ori = buscar(origen);
        int dest = buscar(des);

        if (ori == -1 || dest == -1) {
            System.out.println("El vertice no existe");
            return;
        }
        if (matrizA[ori][dest] == 0) {
            System.out.println("No existe arista entre " + origen + " y " + des);
            return;
        }
        
        matrizA[ori][dest] = 0; //elimina la arista
        System.out.println("Arista " + origen + " -> " + des + " eliminada");
    }
    
    public int verticesT(){
        return vertices.size();
    }
    
    public boolean aristaE(int origen, int destino){
        if (origen < 0 || origen >= vertices.size() 
                || destino < 0 || destino >= vertices.size()) return false;
        return matrizA[origen][destino] !=0;
    }
    
    public Vertice getVertice(int i){
        if (i>=0 && i<vertices.size()) return vertices.get(i);
        
        return null;
    }

    public void mostrar() {
        System.out.println("MATRIZ ADYACENTE");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).getNombre() + "--->");
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizA[i][j] + " ");
            }
            System.out.println();
        }
    }
}
