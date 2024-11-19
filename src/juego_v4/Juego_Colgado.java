package juego_v4;

import java.util.Scanner;

public class Juego_Colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		String[] palabras = {"alemania","polivalente","impresionante","estupefacientes"}; //palabras del juego
		
		int cuantosJugadores = 0;
		while(cuantosJugadores<2) {
			System.out.println("¿Cuantos jugadores juegan?");
			cuantosJugadores = scanner.nextInt();
		}
		
		System.out.println("¿Cuantas rondas jugaran?");
		int rondas = scanner.nextInt();
		
		System.out.println("Elije una de las palabras ocultas:");
		int opcion = scanner.nextInt()-1; // scanner con la opcion a elejir de nuestra palabra oculta
		
		String palabraOculta = palabras[opcion]; //esta sera la palabra con la posicion						
		
		char letra;
		char letraOculta = '_'; // caracter para esconder las letras de las palabras
		int intentosRestantes = 6;
		
		StringBuilder palabraOcultaCompleta = new StringBuilder(); //declaracion del String	Builder para permititr modificaciones en las palabras
		
		//cambio de letras de las palabras por caracter "_"
	    for (int i = 0; i < palabraOculta.length(); i++) { 
	        palabraOcultaCompleta.append('_');
	    }
		
	       
	       
		System.out.println("tas:" + palabraOculta);
		System.out.println("tas:" + palabraOcultaCompleta);

		
	}

}

/*

Reglas del juego:

	1. El juego comienza pidiendo al administrador (un jugador) que elija una palabra secreta, la cual debe ser oculta durante el juego.
	2. Cada jugador tiene que adivinar una letra de la palabra secreta en cada ronda.
	3. El número máximo de intentos por jugador es 6.
	4. Si un jugador adivina correctamente una letra, esta se revela en su posición en la palabra secreta.
	5. Si un jugador se queda sin intentos, pierde la ronda.
	6. El jugador que adivine toda la palabra primero o quien gane más rondas será el ganador.
	
Instrucciones:

	1. El programa preguntar cuantos jugadores quieren jugar. El mínimo de jugadores tiene que ser 2.
	2. El programa preguntará cuantas rondas se quieren jugar.
	3. Para cada ronda, el programa debe:
		· Mostrar las letras acertadas de la palabra secreta (con guiones bajos para las letras no adivinadas).
		· Solicitar a los jugadores que ingresen una letra.
		· Comprobar si la letra ingresada es correcta.
		· Actualizar la palabra secreta con las letras adivinadas correctamente.
		· Contabilizar los intentos restantes para cada jugador.
		· Mostrar el estado de la palabra secreta después de cada intento.
		· Al finalizar las rondas, mostrar el nombre del jugador que haya ganado más rondas.

*/
