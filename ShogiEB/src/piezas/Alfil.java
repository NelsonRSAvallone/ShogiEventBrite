
package piezas;

import shogieb.Cuadro;
import shogieb.Tablero;

/**
 *
 * @author Nelson
 */
public class Alfil extends Pieza{
    
    public Alfil(String colorIn) {
		super(colorIn, "alfil");
		
		if(color == "blanco"){
			simbolo = "^Ai";
		}
		else{
			simbolo = "vAi";
		}
	}
       
	public boolean checkMovimiento(int [] moverDesdeReq, int[]moverHastaReq, String jugadorColor, boolean testRey) {
		
		int moverDesdeX = moverDesdeReq[0];
		int moverDesdeY = moverDesdeReq[1];
		int moverHastaX = moverHastaReq[0];
		int moverHastaY = moverHastaReq[1];
		
		Cuadro toSquare = Tablero.tablero[moverHastaY][moverHastaX];
		
		int moveDistance = Math.abs(moverHastaX - moverDesdeX);
		
		if(!testRey){
			if(toSquare.getTipo() == "rey"){
				return false; //no puede tomar el rey
			}
		}
		
		String direction; //direccion que va a tomar el Alfil
		
		if(moverHastaX > moverDesdeX){
			if(moverHastaY < moverDesdeY){
				direction = "topRite";
			}
			else{
				direction = "botRite";
			}
		}
		else{
			if(moverHastaY < moverDesdeY){
				direction = "topLeft";
			}
			else{
				direction = "botLeft";
			}
		}
		
		
		Cuadro testSquare; //
		
		//for para los movimientos diagonales
		for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++){
			
			if(direction == "topRite"){
				testSquare = Tablero.tablero[moverDesdeY - diagMoveAway][moverDesdeX + diagMoveAway];
			}
			else if(direction == "botRite"){
				testSquare = Tablero.tablero[moverDesdeY + diagMoveAway][moverDesdeX + diagMoveAway];
			}
			else if(direction == "topLeft"){
				testSquare = Tablero.tablero[moverDesdeY - diagMoveAway][moverDesdeX - diagMoveAway];
			}
			else{ //botLeft
				testSquare = Tablero.tablero[moverDesdeY + diagMoveAway][moverDesdeX - diagMoveAway];
			}
			
			if((testSquare.getTipo() != "blank") && (diagMoveAway != moveDistance)){
				return false;
			}
			else if((diagMoveAway == moveDistance) && ((testSquare.getColor() != jugadorColor) || (testSquare.getTipo() == "blank"))){
				return true;
			}
		}
		return false; //
	}

    

   
    
}
