
package shogieb;

import java.util.Scanner;
import piezas.Peon;

/**
 *
 * @author Nelson
 */
public abstract class Tablero {
        //Esto va a estar dibujado al lado y arriba de la matriz.
       static final char SIDE_LETTERS[] = {'A','B','C','D','E','F','G','H','I'};
       static final int SIDE_NUMS[] = {1,2,3,4,5,6,7,8,9};
       public static Cuadro tablero [][] = new Cuadro [9][9]; 
        
       	private static final Scanner scanner = new Scanner(System.in);
        
        private static void setup(){
        //peones
		for(int i = 0; i < 9; i++){
			tablero[1][i] = new Peon("negro");
		}
		
		for(int i = 2; i < 6; i++){ //creando espacios en blanco
			for(int j = 0; j < 9; j++){
				tablero[i][j] = new EspacioEnBlanco();
			}
		}
		
		//peones
		for(int i = 0; i < 9; i++){
			tablero[6][i] = new Peon("blanco");
		}
        
        }

       public static void main(String[] args) {
       System.out.println("=====> SHOGI <====="); //titulo
       }
    }
