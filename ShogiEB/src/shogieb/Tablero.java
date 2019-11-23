
package shogieb;

import java.util.Scanner;
import piezas.Alfil;
import piezas.Lancero;
import piezas.Peon;
import piezas.Torre;

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
         //PINTA ESPACIOS EN BLANCO
            for(int i = 0; i < 9; i++){ //creando espacios en blanco
			for(int j = 0; j < 9; j++){
				tablero[i][j] = new EspacioEnBlanco();
			}
		}   
            
            		
		//Pintado de piezas
		for(int i = 0; i < 9; i++){
			tablero[2][i] = new Peon("negro");
			tablero[6][i] = new Peon("blanco");
                        //torres
                        tablero[1][1]= new Torre("negro");
                        tablero[7][7]= new Torre("blanco");
                        //Alfiles
                        tablero[1][7]= new Alfil("negro");
                        tablero[7][1]= new Alfil("blanco");
                        //Lanceros negros
                        tablero[0][0]= new Lancero("negro");
                        tablero[0][8]= new Lancero("negro");
                        //Lanceros blancos
                        tablero[8][0]= new Lancero("blanco");
                        tablero[8][8]= new Lancero("blanco");
                        
		}
        }      

        //el valor de prevNombre puede ser seteado a null 
	private static String getNombre(int jugadorNum, String prevName){ 
		String nombre;
		
		while(true){
			System.out.print("Jugador " + jugadorNum + " por favor ingrese su nombre.\n>> ");
			nombre = scanner.nextLine().trim();
			
			//si no hay espacios ,si no esta vacio y si los nombres no son los mismos
			if(!nombre.isEmpty() && !(nombre.contains(" ") || nombre.contains("\t")) && !nombre.equals(prevName)) 
				
				break; //de otra forma se le pedira al usuario que escriba su nombre otra vez
			else
				System.out.println("Nombre Invalido. Intente de nuevo.");
		}
		return nombre;
	}
       public static void main(String[] args) {
       System.out.println("=====> SHOGI <====="); //titulo
       
                String ply1Nombre = getNombre(1, null);
		String ply2Nombre = getNombre(2, ply1Nombre);
		
		Jugador blancoPly = new Jugador(ply1Nombre, "blanco");
		Jugador negroPly = new Jugador(ply2Nombre, "negro");
		
		setup(); //obtener el tablero
       
       //Empezar el loop del main
       while(true){
			
			for(int runNum = 1; runNum <= 2; runNum++){ //movimiento para cada jugador
				dibujar(); //mostrar Tablero
				
				int move[][] = new int[2][2];
				
				while(true){
				
					if(runNum == 1){ //primera corrida jugador blanco
						move = blancoPly.getMove();
					}
					else{ //segunda corrida, si no es blanco es negro
						move = negroPly.getMove();
					}
				
					if(move[0][0] == -1){ //restartear el loop si la entrada esta mal
						System.out.println("Movimiento Invalido, Intente de nuevo!");
						continue;
					}
					
					int[] moveFrom = move[0];
					int[] moveTo = move[1];
					Cuadro fromSquare = tablero[moveFrom[1]][moveFrom[0]];
				
					boolean checkValue;
					if(runNum == 1){
						checkValue = fromSquare.checkMovimiento(moveFrom, moveTo, "blanco", false); //checking for pawn move validity
					}
					else{
						checkValue = fromSquare.checkMovimiento(moveFrom, moveTo, "negro", false);
					}
					if(checkValue){
						update(moveFrom, moveTo);
						
						if(runNum == 1){
							if (checkForCheckOrMate("blanco") == "check"){
								System.out.println("Check!");
							}
						}
						else{
							if (checkForCheckOrMate("negro") == "check"){
								System.out.println("Check!");
							}
						}
						break;
					}
					System.out.println("Movimiento Invalido, Intente de nuevo!"); //no se imprime si se llama al break
				}
			}
		}
       
       }//fin main
       //chek jake-------------------------------------------------------------------------------
       private static String checkForCheckOrMate(String plyColor){ //chekeo de ganador o Jaque
		for(int kingY = 0; kingY < 9; kingY++){
			for(int kingX = 0; kingX < 9; kingX++){
				Cuadro kingSquare = tablero[kingY][kingX];
				
				String kingColor;
				if(plyColor == "blanco"){
					kingColor = "negro";
				}
				else{ //black
					kingColor = "blanco";
				}
				
				if((kingSquare.getTipo() == "king") && (kingSquare.getColor() == kingColor)){
					
					for(int threatY = 0; threatY < 9; threatY++){
						for(int threatX = 0; threatX < 9; threatX++){
							Cuadro threatSquare = tablero[threatY][threatX];
							
							if((threatSquare.getTipo() != "blank") && (threatSquare.getColor() == plyColor)){
								int[] moveFrom = {threatX, threatY};
								int[] moveTo = {kingX, kingY};
							
								if(threatSquare.checkMovimiento(moveFrom, moveTo, plyColor, true)){
									return "check";
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
       //--------------------------------------------------------------------------------
       
       private static void update(int[] origLoc, int[] newLoc){ //seteando la nueva posicion de la pieza y seteando el lugar viejo a blank
		tablero[newLoc[1]][newLoc[0]] = tablero[origLoc[1]][origLoc[0]];
		tablero[origLoc[1]][origLoc[0]] = new EspacioEnBlanco();
	}
       
       //DIBUJAR--------------------------------------------------------------
       private static void dibujar(){
		System.out.print("\n   ");
		
		for(char i: SIDE_LETTERS){ //imprimir letras en la parte de arriba
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n   ");
		
		for(int i = 0; i < 9; i++){
			System.out.print(" --- ");
		}
		
		System.out.print("\n");
		for(int i = 0; i < 9; i++){ //haciendo loop en el cuadro e imprime simbolos
			System.out.print(" " + (9 - i) + " "); //imprime numeros a la izquierda
			
			for(Cuadro j: tablero[i]){
				System.out.print("|" + j.getSimbolo() + "|");
			}
			System.out.print(" " + (9 - i) + " "); //imprime numeros a la derecha
			
			System.out.print("\n   ");//para obtener la siguiente linea
			
			for(int j = 0; j < 9; j++){
				System.out.print(" --- ");
			}
			System.out.print("\n");
		}
		System.out.print("   ");
		for(char i: SIDE_LETTERS){ //imprime letras abajo
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n\n");
	}//fin dibujar
       
       
    }
