package Clases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author diego jaimes escobar
 */
public class Arista {

    private Vertice des, ori;


    public Vertice getDes() {
        return des;
    }

    public Vertice getOri() {
        return ori;
    }
    //constructor
    public Arista(Vertice ori, Vertice des) {
        this.ori = ori;
        this.des = des;
    }
    //diseño a las aristas y se dibujan
    public void pintar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //se aplica un casting a g de Graphics
        g2.setColor(Color.BLUE); //se pinta de color azul
        g2.setStroke(new BasicStroke(4)); //cambiar el grosor de las aristas
        g2.drawLine(ori.getX(), ori.getY(), des.getX(), des.getY()); //dibujar la arista
        

        // se calcula el punto medio
        int mx = (ori.getX() + des.getX()) / 2;
        int my = (ori.getY() + des.getY()) / 2;
        
        int offset = 10; //la distancia que se tendra para el acumulamiento
        if (ori.getY() < des.getY()) my += offset; //baja en el eje de las Y
        else my -= offset; //sube en el eje de las Y
       
        //se colorea de color rojo las letras que acompañan a la arista (etiqueta)
        g2.setColor(Color.RED);
        g2.drawString(ori.getNombre() + " , " + des.getNombre(), mx, my);
 

    }
}
