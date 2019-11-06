
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
        
    
    private int convertirANum (char charIn)//si este metodo retorna un -1 la letra no es valida
                                            // el usuario va a entrar un char pero necesita un numero para el programa
    {
    int numOut = -1;
        for (int i = 0; i < Tablero.SIDE_LETTERS.length; i++) 
        {
            if (Tablero.SIDE_LETTERS[i]== charIn) 
            {
                numOut = i;
            }
        }
        return numOut;
    }
    
    //convierte el numero string a numero real int y se fija si es menor que 9
    private int convertirCharNumANum(char charIn)
    {
    int numOut = -1;// is -1 es retornado el numero es invalido
    int convertidoNum = Character.getNumericValue(charIn);
    
        for (int i: Tablero.SIDE_NUMS) 
        {
            if( i == convertidoNum)
            {
            numOut = convertidoNum;
            }
        }
    
    
    return numOut;
    }
    
    
}
