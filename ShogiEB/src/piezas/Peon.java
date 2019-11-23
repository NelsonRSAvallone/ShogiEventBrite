package piezas;

import shogieb.Cuadro;
import shogieb.Tablero;

/**
 *
 * @author Nelson
 */
public class Peon extends Pieza {

    public Peon(String colorIn) {
        super(colorIn, "peon");

        if (color == "blanco") {
            simbolo = "^Pe";
        } else {
            simbolo = "vPe";
        }
    }

    public boolean checkMovimiento(int[] moverDesdeReq, int[] moverHastaReq, String jugadorColor, boolean testRey) {

        int moverDesdeX = moverDesdeReq[0];
        int moverDesdeY = moverDesdeReq[1];
        int moverHastaX = moverHastaReq[0];
        int moverHastaY = moverHastaReq[1];

        //Esta variable me va a servir para indicar si el que se mueve es el blanco o el negro
        int moveAdelanteUno;

        Cuadro aCuadro = Tablero.tablero[moverHastaY][moverHastaX];

        if (!testRey) {
            if (aCuadro.getTipo() == "rey") {
                return false; //no se puede mover para tomar al rey
            }
        }

        if (jugadorColor == "blanco") { //cambio de direccion de pieza blanca

            moveAdelanteUno = -1;

        } else { //negro

            moveAdelanteUno = 1;

        }
        //movimiento del peon y tambien permite que se coman.
        if (moverHastaY == moverDesdeY + moveAdelanteUno) {

            if (moverHastaX == moverDesdeX + moveAdelanteUno) {
                return false;
            }
            return true;
        }
        return false; //solo llega hasta aqui si todo lo demas falla.
    }
}
