
package piezas;

import shogieb.Cuadro;
import shogieb.Tablero;

/**
 *
 * @author Nelson
 */
public class GenPlata extends Pieza{
    
     public GenPlata(String colorIn) {
        super(colorIn, "genP");

        if (color == "blanco") {
            simbolo = "^Gp";
        } else {
            simbolo = "vGp";
        }
    }
    
     public boolean checkMovimiento(int[] moverDesdeReq, int[] moverHastaReq, String jugadorColor, boolean testRey) {
         
         int moverDesdeX = moverDesdeReq[0];
        int moverDesdeY = moverDesdeReq[1];
        int moverHastaX = moverHastaReq[0];
        int moverHastaY = moverHastaReq[1];
        
        Cuadro aCuadro = Tablero.tablero[moverHastaY][moverHastaX];
         
         
         return false;
     }
}
