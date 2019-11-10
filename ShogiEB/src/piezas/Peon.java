
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
		
		if(color == "blanco"){
			simbolo = "bPa";
		}
		else{
			simbolo = "nPa";
		}
	}

    public boolean checkMovimiento(int [] moverDesdeReq, int[]moverHastaReq, String jugadorColor, boolean testRey) {
		
		int moverDesdeX = moverDesdeReq[0];
		int moverDesdeY = moverDesdeReq[1];
		int moverHastaX = moverHastaReq[0];
		int moverHastaY = moverHastaReq[1];
		
		
		int moveAdelanteUno;
		
		
		Cuadro aCuadro = Tablero.tablero[moverHastaY][moverHastaX];
		
		if(!testRey){
			if(aCuadro.getTipo() == "rey"){
				return false; //no se puede mover para tomar al rey
			}
		}
		
		if(jugadorColor == "blanco"){ //cambio de direccion de pieza blanca
			
			moveAdelanteUno = -1;
			
		}
		else{ //negro
			
			moveAdelanteUno = 1;
			
		}
			
		if(moverHastaY == moverDesdeY + moveAdelanteUno ){
			
                    if(moverHastaX == moverDesdeX + moveAdelanteUno) {
                        return false;
                    }
                        return true;
		}
		return false; //solo llega hasta aqui si todo lo demas falla.
	}	
}

			
			
		
		

    
