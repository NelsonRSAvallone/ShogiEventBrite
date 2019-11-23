package piezas;

import shogieb.Cuadro;
import shogieb.Tablero;

/**
 *
 * @author Nelson
 */
public class Rey extends Pieza {

    public Rey(String colorIn) {
        super(colorIn, "rey");

        if (color == "blanco") {
            simbolo = "^Ro";
        } else {
            simbolo = "vRo";
        }
    }

    public boolean checkMovimiento(int[] moverDesdeReq, int[] moverHastaReq, String jugadorColor, boolean testRey) {

        int moverDesdeX = moverDesdeReq[0];
        int moverDesdeY = moverDesdeReq[1];
        int moverHastaX = moverHastaReq[0];
        int moverHastaY = moverHastaReq[1];

        Cuadro aCuadro = Tablero.tablero[moverHastaY][moverHastaX];

        for (int moverseX = -1; moverseX <= 1; moverseX++) {
            for (int moverseY = -1; moverseY <= 1; moverseY++) {
                if (moverHastaX == moverDesdeX + moverseX && moverHastaY == moverDesdeY + moverseY) {
                    if ((aCuadro.getTipo() != "blank") && (aCuadro.getColor() != jugadorColor)) {
                        return true;
                    } else if (aCuadro.getTipo() == "blank") {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
