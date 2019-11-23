
package piezas;

import shogieb.Cuadro;
import shogieb.Tablero;

/**
 *
 * @author Nelson
 */
public class Lancero extends Pieza{
    
    
    public Lancero(String colorIn) {
		super(colorIn, "lancero");
		
		if(color == "blanco"){
			simbolo = "^Lo";
		}
		else{
			simbolo = "vLo";
		}
	}
    
    public boolean checkMovimiento(int [] moverDesdeReq, int[]moverHastaReq, String jugadorColor, boolean testRey) {
  
  
                int moverDesdeX = moverDesdeReq[0];
		int moverDesdeY = moverDesdeReq[1];
		int moverHastaX = moverHastaReq[0];
		int moverHastaY = moverHastaReq[1];
                
                Cuadro aCuadro = Tablero.tablero[moverHastaY][moverHastaX];
                
                String direccion;
                
                if (!testRey)
                {
                    if (aCuadro.getTipo() == "rey") 
                    {
                        return false; //no se puede mover para tomar al rey
                    }
                }
                
                if(moverHastaX == moverDesdeX){
			if(moverHastaY > moverDesdeY){
				direccion = "abajo";
			}
			else{
				direccion = "arriba";
			}
		}
		else{
			return false;
		}
    Cuadro testCuadro;
    
    
    int desplazMax = Math.abs(moverHastaY - moverDesdeY); //desplazamiento maximo dependiendo en los valores
				
			for(int desplazamiento = 1; desplazamiento <= desplazMax; desplazamiento++){ //haciendo loop a travez de los cuadros en el camino de la torre
				
				if(direccion == "arriba"){
					testCuadro = Tablero.tablero[moverDesdeY - desplazamiento][moverDesdeX];
					
					if((testCuadro.getTipo() != "blank") && (desplazamiento != desplazMax)){
						return false;
					}
					else if((desplazamiento == desplazMax) && ((testCuadro.getTipo() == "blank") || (testCuadro.getColor() != jugadorColor))){
						return true;
					}
				}
//				
			}
    return false;                    
    }
    
}
