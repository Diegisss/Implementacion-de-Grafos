package Clases;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author diego jaimes escobar
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
        Graphics2D g2 = (Graphics2D) g; 
        g2.setColor(Color.GREEN); 
        g2.fillOval(this.x - d / 2, this.y - d / 2, d, d);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.drawOval(this.x - d / 2, this.y - d / 2, d, d);
        g2.drawString(nombre, x - nombre.length() * 3, y +4);
    }
    
    //getters y setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return nombre + " (" + NumVertice + ")";
    }
}
