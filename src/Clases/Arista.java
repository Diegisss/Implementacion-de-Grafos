/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author diego123
 */
public class Arista {
    private Vertice origen, des;
    private int peso;
    
    public Arista(Vertice origen, Vertice des){
        this(origen, des, 1);
    }
    
    public Arista(Vertice origen, Vertice des, int peso){
        this.origen = origen;
        this.des = des;
        this.peso = peso;
    }
    
    public Vertice getOrigen(){
        return origen;
    }

    public Vertice getDes() {
        return des;
    }

    public int getPeso() {
        return peso;
    }
    @Override
    public String toString(){
        return origen.getNombre() + des.getNombre() + "peso" + " ("+ peso + ")";
    }
}
