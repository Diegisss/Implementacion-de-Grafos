package Clases;

import static Clases.VerticeG.d;
import java.awt.Graphics;

/**
 *
 * @author diego123
 */
public class Vertice {

    private String nombre;
    private int NumVertice;
    
    private int x, y;
    public static final int d = 50;
    

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.NumVertice = -1;
    }
    
    public Vertice (int x, int y, String nombre){
        this.x = x;
        this.y = y;
        this.nombre = nombre;
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
    
    public void pintar(Graphics g) {
        g.drawOval(this.x - d / 2, this.y - d / 2, d, d);
        g.drawString(nombre, x - nombre.length() * 3, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return nombre + " (" + NumVertice + ")";
    }
}
