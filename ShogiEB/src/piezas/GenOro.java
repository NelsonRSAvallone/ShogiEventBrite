
package piezas;

/**
 *
 * @author Nelson
 */
public class GenOro extends Pieza{
    
    public GenOro(String colorIn) {
        super(colorIn, "genO");

        if (color == "blanco") {
            simbolo = "^Go";
        } else {
            simbolo = "vGo";
        }
    }
    
     public boolean checkMovimiento(int[] moverDesdeReq, int[] moverHastaReq, String jugadorColor, boolean testRey) {
     
         int moverDesdeX = moverDesdeReq[0];
        int moverDesdeY = moverDesdeReq[1];
        int moverHastaX = moverHastaReq[0];
        int moverHastaY = moverHastaReq[1];
         
         
         return false;
     }
}
