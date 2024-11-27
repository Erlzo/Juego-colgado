package juego_v4;

import java.util.Scanner;

public class Juego_Colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		String[] palabras = {"alemania","polivalente","impresionante","estupefacientes"}; //palabras del juego
		
		int cuantosJugadores = 0; // se pide los jugadores que van a jugar
		while(cuantosJugadores<2) { // minimo 2 jugadores
			System.out.println("¿Cuantos jugadores juegan?");
			cuantosJugadores = scanner.nextInt();
		}
		
		System.out.println("¿Cuantas rondas jugaran?"); // se pide las rondas que quieren jugar
		int rondas = scanner.nextInt();
		
		System.out.println("Elije una de las palabras ocultas:");
		int opcion = scanner.nextInt()-1; // scanner con la opcion a elejir de nuestra palabra oculta
		
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
	        
	        if (letraEncontrada) {
	            System.out.println("¡Bien! La letra '" + letraAdivinada + "' está en la palabra."); // si esta la letra = mensaje felicitando
	        } else {
	            intentosRestantes--;
	            System.out.println("Lo siento, la letra '" + letraAdivinada + "' no está en la palabra."); // si la letra no esta resta un intento + mensaje indicando letra incorrecta
	        }
	    
		}
		
		// Indica si se ganó o se perdió en el juego
		
	    if (new String(palabraGuiones).equals(palabraOculta)) {
	        System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraOculta);
	    } else {
	        System.out.println("\nLo siento, te has quedado sin intentos. Has perdido.");
	        System.out.println("\nLa palabra era: " + palabraOculta);
	    }
	    
	}
}



/*

Reglas del juego:

si						1. El juego comienza pidiendo al administrador (un jugador) que elija una palabra secreta, la cual debe ser oculta durante el juego.
si | faltan jugadores	2. Cada jugador tiene que adivinar una letra de la palabra secreta en cada ronda.
si						3. El número máximo de intentos por jugador es 6.
si						4. Si un jugador adivina correctamente una letra, esta se revela en su posición en la palabra secreta.
si						5. Si un jugador se queda sin intentos, pierde la ronda.
falta					6. El jugador que adivine toda la palabra primero o quien gane más rondas será el ganador.
	
Instrucciones:

si	1. El programa preguntar cuantos jugadores quieren jugar. El mínimo de jugadores tiene que ser 2.
si	2. El programa preguntará cuantas rondas se quieren jugar.
	3. Para cada ronda, el programa debe:
si		· Mostrar las letras acertadas de la palabra secreta (con guiones bajos para las letras no adivinadas).
si		· Solicitar a los jugadores que ingresen una letra.
si		· Comprobar si la letra ingresada es correcta.
si		· Actualizar la palabra secreta con las letras adivinadas correctamente.
si		· Contabilizar los intentos restantes para cada jugador.
si		· Mostrar el estado de la palabra secreta después de cada intento.
falta		· Al finalizar las rondas, mostrar el nombre del jugador que haya ganado más rondas.

*/
