
package piezas;

/**
 *
 * @author Nelson
 */
public class Peon extends Pieza {
public Peon(String colorIn) {
		super(colorIn, "peon");
		
		if(color == "white"){
			simbolo = "wPa";
		}
		else{
			simbolo = "bPa";
		}
	}

    @Override
    public boolean checkMovimiento(int[] moverDesde, int[] moverHasta, String jugadorColor, boolean testRey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
