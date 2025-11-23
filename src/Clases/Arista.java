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
    private Vertice des;
    private int peso;

    public Arista(Vertice des, int peso){
        this.des = des;
        this.peso = peso;
    }

    public Vertice getDes() {
        return des;
    }

    public int getPeso() {
        return peso;
    }
    @Override
    public String toString(){
        return des.getNombre() + " peso (" + peso + ")";
    }
}
