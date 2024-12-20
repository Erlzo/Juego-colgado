package juego_v4;

import java.util.Scanner;

public class Juego_Colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		String[] palabras = {"alemania","polivalente","impresionante","estupefacientes"}; //palabras del juego
		
		System.out.println("¿Cuantos jugadores juegan? | Mínimo 2 jugadores.");
		int numJugadores = scanner.nextInt();
		int[] cuantosJugadores = new int[numJugadores];
		
		System.out.println("¿Cuantas rondas jugaran?"); // se pide las rondas que quieren jugar
		int rondas = scanner.nextInt();
		
		int rondasGanadas = 0;
		int rondasPerdidas = 0;
		
		for(int k = 0; k < rondas; k++) {
				if(k > 0) {
					System.out.println("\n¡Nueva ronda!");
				}

			System.out.println("Elije una de las palabras ocultas: (1) (2) (3) (4)");
			int opcion = scanner.nextInt()-1; // scanner con la opcion a elejir de nuestra palabra oculta
			
			if(opcion < 0 || opcion > 4) {
				System.out.println("Error:");
				System.out.println("Elije una de las palabras indicadas. (1) (2) (3) (4)");
				break;
			}
			
			String palabraOculta = palabras[opcion]; //esta sera la palabra con la posicion						
			
			int intentosRestantes = 6; // numero de intentos restantes por defecto
			
			int letrasPalabraOculta = palabraOculta.length();
			
			char [] palabraGuiones = new char[letrasPalabraOculta];
							
			for (int i = 0; i < palabraGuiones.length; i++) { 
				palabraGuiones[i] = '_'; // se sustituye las letras por "_"
		    }
			  
			while (intentosRestantes > 0 && new String(palabraGuiones).contains("_")) { //bucle se ejecuta mientras queden intentos y no se haya completado la palabra / no hayan mas "_"
		        System.out.println("Intentos restantes: " + intentosRestantes); // muestra intentos restantes
		        System.out.println("Palabra actual: " + new String(palabraGuiones)); // muestra la palabra oculta
		        System.out.print("Introduce una letra: "); // texto pidiendo una letra
		        		        
		        // Leer una letra
		        
		        char letraAdivinada = scanner.next().toLowerCase().charAt(0);// scanner pide la letra, este la pasa a minuscula por defecto, se escogera el caracter en posicion 0 es decir 'abc' = 'a'
		        
		        // Validar si es una letra
		        if (!Character.isLetter(letraAdivinada)) { // combrueba que en el scanner de letra se haya escrito una letra
		            System.out.println("Por favor, introduce solo una letra válida.");
		        }
		        
		        boolean letraEncontrada = false;
	
		        for(int i = 0; i < palabraOculta.length();i++) { // bucle que recorre letra a letra la palabra oculta
		        	if(palabraOculta.charAt(i) == letraAdivinada) {
		        		palabraGuiones[i] = letraAdivinada;
		                letraEncontrada = true;
		        	}
		        }
		        	        
		        // Actualizar intentos o continuar
		        
		        if (letraEncontrada == true) {
		            System.out.println("¡Bien! La letra '" + letraAdivinada + "' está en la palabra."); // si esta la letra = mensaje felicitando
		        } else {
		            intentosRestantes--;
		            System.out.println("Lo siento, la letra '" + letraAdivinada + "' no está en la palabra."); // si la letra no esta resta un intento + mensaje indicando letra incorrecta
		        }
		    
			}
			
			// Indica si se ganó o se perdió en el juego
			
		    if (new String(palabraGuiones).equals(palabraOculta)) {
		    	rondasGanadas++;
		        System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraOculta);
		    } else {
		    	rondasPerdidas++;
		        System.out.println("\nLo siento, te has quedado sin intentos. Has perdido.");
		        System.out.println("\nLa palabra era: " + palabraOculta);
		    }
		    
		    if(k == rondas || k < rondas ) {
		        System.out.println("\nRONDAS = Win: " + rondasGanadas + " | Lose: " + rondasPerdidas);
	        }
		}
		
	}
}
