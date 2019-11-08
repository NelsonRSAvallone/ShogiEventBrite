
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
			
		if(moverHastaY == moverDesdeY + moveAdelanteUno){
			
			//mover para tomar una pieza que es de diferente color en diagonal
			if((moverHastaX == moverDesdeX - 1) || (moverHastaX == moverDesdeX + 1)){
				if((aCuadro.getTipo() != "blank") && (aCuadro.getColor() != jugadorColor)){
					return true; 
				}
			}	
			
                        //movimiento hacia adelante 1 a un espacio vacio
			else if((moverHastaX == moverDesdeX) && (aCuadro.getTipo() == "blank")){ 
				return true;
			}
		}
		//move forward 2 straight and is to blank space
		//else if((moverHastaY == moverDesdeY) && (moverHastaX == moverDesdeX) && (aCuadro.getTipo() == "blank")){ 
		//	if(moverDesdeY == pawnRowOnPlySide){ //if pawn moves from the starting row
		//		return true;
		//	}
		//}
		
		return false; //only get here if other possiblities fail
	}	

    
}
