
package shogieb;

import java.util.Scanner;

/**
 *
 * @author Nelson
 */
public class Jugador {
    
    private String nombre;
    private String color;
    private final Scanner scanner = new Scanner (System.in);
    
    Jugador (String nombreIn, String colorIn)
    {
        nombre = nombreIn;
        color = colorIn;
        
    }
    
    private int convertirANum (char charIn)
    {
    int numOut = -1;
        for (int i = 0; i < Tablero.SIDE_LETTERS.length; i++) 
        {
            if (Tablero.SIDE_LETTERS[i]== charIn) {
                numOut = i;
            }
        }
        return numOut;
    }
    
    
    
}
