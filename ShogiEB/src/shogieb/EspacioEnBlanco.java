
package shogieb;

/**
 *
 * @author Nelson
 */
public class EspacioEnBlanco extends Cuadro{
    
    
    public EspacioEnBlanco() {
		super("blank");
		simbolo = "   ";
		color = null; //un cuadrado blanco sin color
		
	}

	public void move(int[] moveToLoc) {
	}

	public boolean checkMovimiento(int [] moverDesde, int[]moverHasta, String jugadorColor, boolean testRey) { //unused
		return false;
	}

    
    }

    
    

