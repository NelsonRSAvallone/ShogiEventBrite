package piezas;

import shogieb.Cuadro;
import shogieb.Tablero;

/**
 *
 * @author Nelson
 */
public class Torre extends Pieza {

    public Torre(String colorIn) {
        super(colorIn, "torre");

        if (color == "blanco") {
            simbolo = "^To";
        } else {
            simbolo = "vTo";
        }
    }

    public boolean checkMovimiento(int[] moverDesdeReq, int[] moverHastaReq, String jugadorColor, boolean testRey) {

        int moverDesdeX = moverDesdeReq[0];
        int moverDesdeY = moverDesdeReq[1];
        int moverHastaX = moverHastaReq[0];
        int moverHastaY = moverHastaReq[1];

        Cuadro aCuadro = Tablero.tablero[moverHastaY][moverHastaX];

        String direccion;

        if (!testRey) {
            if (aCuadro.getTipo() == "rey") {
                return false; //no se puede mover para tomar al rey
            }
        }

        //RITO
        if (moverHastaY == moverDesdeY) {
            if (moverHastaX > moverDesdeX) {
                direccion = "rite";
            } else {
                direccion = "izquierda";
            }
        }//FIN RITO
        else if (moverHastaX == moverDesdeX) {
            if (moverHastaY > moverDesdeY) {
                direccion = "abajo";
            } else {
                direccion = "arriba";
            }
        } else {
            return false;
        }

        Cuadro testCuadro;

        if ((direccion == "rite") || (direccion == "izquierda")) {
            int desplazMax = Math.abs(moverHastaX - moverDesdeX);//desplazamiento maximo dependiendo en los valores

            for (int desplazamiento = 1; desplazamiento <= desplazMax; desplazamiento++) //haciendo loop a travez de los cuadros en el camino de la torre
            {
                if (direccion == "rite") {
                    testCuadro = Tablero.tablero[moverDesdeY][moverDesdeX + desplazamiento];

                    if ((testCuadro.getTipo() != "blank") && (desplazamiento != desplazMax)) {
                        return false;
                    } else if ((desplazamiento == desplazMax) && ((testCuadro.getTipo() == "blank") || (testCuadro.getColor() != jugadorColor))) {
                        return true;
                    }
                } else {
                    testCuadro = Tablero.tablero[moverDesdeY][moverDesdeX - desplazamiento];

                    if ((testCuadro.getTipo() != "blank") && (desplazamiento != desplazMax)) {
                        return false;
                    } else if ((desplazamiento == desplazMax) && ((testCuadro.getTipo() == "blank") || (testCuadro.getColor() != jugadorColor))) {
                        return true;
                    }
                }

            }
        } //
        else { // direccion abajo arriba
            int desplazMax = Math.abs(moverHastaY - moverDesdeY); //desplazamiento maximo dependiendo en los valores

            for (int desplazamiento = 1; desplazamiento <= desplazMax; desplazamiento++) { //haciendo loop a travez de los cuadros en el camino de la torre

                if (direccion == "arriba") {
                    testCuadro = Tablero.tablero[moverDesdeY - desplazamiento][moverDesdeX];

                    if ((testCuadro.getTipo() != "blank") && (desplazamiento != desplazMax)) {
                        return false;
                    } else if ((desplazamiento == desplazMax) && ((testCuadro.getTipo() == "blank") || (testCuadro.getColor() != jugadorColor))) {
                        return true;
                    }
                } else {
                    testCuadro = Tablero.tablero[moverDesdeY + desplazamiento][moverDesdeX];

                    if ((testCuadro.getTipo() != "blank") && (desplazamiento != desplazMax)) {
                        return false;
                    } else if ((desplazamiento == desplazMax) && ((testCuadro.getTipo() == "blank") || (testCuadro.getColor() != jugadorColor))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
