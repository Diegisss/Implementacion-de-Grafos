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
        vertices.add(new Vertice(nombre));
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
}
