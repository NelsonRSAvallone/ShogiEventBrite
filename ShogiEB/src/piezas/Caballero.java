
package piezas;

import shogieb.Cuadro;
import shogieb.Tablero;

/**
 *
 * @author Nelson
 */
public class Caballero extends Pieza{
    
    public Caballero(String colorIn) {
		super(colorIn, "caballero");
		
		if(color == "blanco"){
			simbolo = "^Cn";
		}
		else{
			simbolo = "vCn";
		}
	}
    
    
    
    public boolean checkMovimiento(int[] moverDesdeReq, int[] moverHastaReq, String jugadorColor, boolean testRey) {
                
                int moveDesdeX = moverDesdeReq[0];
		int moveDesdeY = moverDesdeReq[1];
		int moveHastaX = moverHastaReq[0];
		int moveHastaY = moverHastaReq[1];
		
		Cuadro aCuadro = Tablero.tablero[moveHastaY][moveHastaX];
		
		if(!testRey){
			if(aCuadro.getTipo() == "rey"){
				return false; 
			}
		}
		
		boolean locationPass = false; //falso default
		
		for(int displaceX = -2; displaceX <= 2; displaceX++){
		
			if(displaceX != 0){
				if(moveHastaX == moveDesdeX + displaceX){
					
					if(Math.abs(displaceX) == 1){ //si el desplazamiento x fuese 1 El desplazamiento Y debe ser 2
						for(int displaceY = -2; displaceY <= 2; displaceY += 4){
							if(moveHastaY == moveDesdeY + displaceY){
								locationPass = true;
							}
						}
					}
					else{ //Al revez de arriba
						for(int displaceY = -1; displaceY <= 1; displaceY += 2){
							if(moveHastaY == moveDesdeY + displaceY){
								locationPass = true;
							}
						}
					}
				}
			}
		}
		if(locationPass){ 
			
			if((aCuadro.getTipo() == "blank") || (aCuadro.getColor() != jugadorColor)){
				return true;
			}
		}
		
		return false;
	}
    
    
    
    
}
