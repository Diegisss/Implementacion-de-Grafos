/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author diego123
 */
public class Vertice {

    private String nombre;
    private int NumVertice;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.NumVertice = -1;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getNumVertice(){
        return NumVertice;
    }

    /*public boolean identico(Vertice x) {
        return nombre.equals(x.nombre);
    }*/

    public void asignarVertice(int x) {
        NumVertice = x;
    }

    @Override
    public String toString() {
        return nombre + " (" + NumVertice + ")";
    }
}
