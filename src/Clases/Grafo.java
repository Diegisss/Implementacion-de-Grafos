/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author diego123
 */
public class Grafo {

    private ArrayList<Vertice> vertices;
    private ArrayList<ArrayList<Arista>> adyacencia;

    public Grafo() {
        vertices = new ArrayList<>();
        adyacencia = new ArrayList<>();
    }

    public void AgregarVertice(String nombre) {
        Vertice verti = new Vertice(nombre);
        verti.asignarVertice(vertices.size());
        vertices.add(verti);
        adyacencia.add(new ArrayList<>());
    }

    public int BuscarVerIndice(String nombre) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getNombre().equals(nombre)) {
                return i;
            }

        }
        return -1;
    }

    public void AgregarArista(String origen, String des, int peso) {
        int ori = BuscarVerIndice(origen);
        int dest = BuscarVerIndice(des);

        if (ori == -1 || dest == -1) {
            System.out.println("El vertice no existe");
            return;
        }
        adyacencia.get(ori).add(new Arista(vertices.get(dest), peso));
    }

    public void mostrar() {
        System.out.println("LISTA ADYACENTE");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).getNombre() + "--->");
            for (Arista a : adyacencia.get(i)) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public int getNumVertice() {
        return vertices.size();
    }

    public Vertice getVertice(int v) {
        return vertices.get(v);
    }

    public ArrayList<Arista> getAdyacentes(int a) {
        return adyacencia.get(a);
    }
}
