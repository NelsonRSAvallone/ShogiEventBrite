
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
    }//fin convertir charNumANum
    public int[][] getMove(){ //retorna un arry de x y de Y
		
		int[][] move = new int[2][2];
		for(int runNum = 1; runNum <= 2; runNum++){
			while(true){
				if(runNum == 1){ //en la primera jugada reguntar desde donde se mueve
					System.out.print(nombre + ", ingrese desde donde quiere mover (EJ: E4)\n>> "); //prompt
				}
				else{ //segundo hasta donde
					System.out.print(nombre + ", ingrese hasta donde moverse. (EJ: E4)\n>> ");
				}
				String moveIn = scanner.nextLine().trim();
			
				// che quea lugares vacios y si no se ingreso nada y si son mas de 2 caracteres
				if(!moveIn.isEmpty() && moveIn.length() <= 2 && !(moveIn.contains(" ") || moveIn.contains("\t"))){
				
					if(!Character.isDigit(moveIn.charAt(0)) && Character.isDigit(moveIn.charAt(1))){
						//el primer char es un char y el segundo es un digito
						int x, y;
			
						if((x = convertirANum(Character.toUpperCase(moveIn.charAt(0)))) != -1){
							if((y = convertirCharNumANum(moveIn.charAt(1))) != -1){
								y = 9 - y; //intercambiar el valor asi el valor 0 queda arriba 
								int tempArray[] = {x, y};
								if(runNum == 1){
									if(Tablero.tablero[y][x].getTipo() == "blank" || Tablero.tablero[y][x].getColor() != color){ 
										
										//retornndo un array llenode -1 si la primera localizacion no es punto hacia la pieza
										//o si la pieza no es del mismo color que el jugador
										tempArray[0] = -1;																
										tempArray[1] = -1;
										int[][] errorArray = {tempArray, tempArray};
										return errorArray;
									}
								}
								
								move[runNum - 1] = tempArray;
								break;
							}
						}
					}
				}
				System.out.println("Locacion Invalida. Intente de nuevo."); //solo llegas aca si todo lo demas ah fallado
			}		
		}
		return move;
	}
    
    
}//fin jugador
