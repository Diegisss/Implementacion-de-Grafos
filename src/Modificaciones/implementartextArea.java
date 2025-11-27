package Modificaciones;

import Clases.Grafo;
import Recorridos.recorridoAnchura;
import Recorridos.recorridoProfundidad;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author diego jaimes escobar
 */
public class implementartextArea {
    private Grafo grafo;
    
    //constructor
    public implementartextArea(Grafo grafo) {
        this.grafo = grafo;
    }
    
    public String obMatriz(){
        ByteArrayOutputStream pasar = new ByteArrayOutputStream();
        //se convierte el ByteArray en un PrintStream casi parecido al System.out
        PrintStream d = new PrintStream(pasar);
        //se guarda el original o viejo paar que se restaure mas adelante
        PrintStream viejo = System.out;
        //aqui se redirige al System.out 
        System.setOut(d);
        
        grafo.mostrar();
        
        //aplicamos forzamiento
        System.out.flush();
        //se restaura la salida original de la consola
        System.setOut(viejo);
        
        //regresamos y a su vez se convierte en String lo que se captura
        return pasar.toString();
    }
    //lo mismo para los demas...
    
    public String obAnchura(String origen){
        ByteArrayOutputStream pasar = new ByteArrayOutputStream();
        PrintStream d = new PrintStream(pasar);
        PrintStream viejo = System.out;
        System.setOut(d);
        
        recorridoAnchura.recorresAnchura(grafo, origen);
        System.out.flush();
        System.setOut(viejo);
        return pasar.toString();
    }
    
    public String obProfundidad(String origen){
        ByteArrayOutputStream pasar = new ByteArrayOutputStream();
        PrintStream d = new PrintStream(pasar);
        PrintStream viejo = System.out;
        System.setOut(d);
        
        recorridoProfundidad.recorresProfundidad(grafo, origen);
        System.out.flush();
        System.setOut(viejo);
        return pasar.toString();
    }
}
