package Ruleta;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
// Creo la clase ruleta
class Ruleta {
	// Atributos
	Random random = new Random();
	Scanner sc = new Scanner(System.in);
	//Array de colores	
	String[] colores = {
        "Verde",  // 0
        "Rojo", "Negro", "Rojo", "Negro", "Rojo", "Negro", "Rojo", "Negro", "Rojo", "Negro", // 1-10
        "Negro", "Rojo", "Negro", "Rojo", "Negro", "Rojo", "Negro", "Rojo", "Rojo", "Negro", // 11-20
        "Rojo", "Negro", "Rojo", "Negro", "Rojo", "Negro", "Rojo", "Negro", "Negro", "Rojo", // 21-30
        "Negro", "Rojo", "Negro", "Rojo", "Negro", "Rojo" // 31-36
    };
	
	
	//Atributos Económicos
	double saldo;
	
	//Constructor
	public Ruleta(double saldo) {
		if(saldo > 0) {
			this.saldo = saldo;
		} else {
			System.out.println("Toma un euro");
			this.saldo = 1;
		}
    }
	
	//Hashmap para guardar todas las apuestas. 
	
	HashMap <String, Double> apuestas = new HashMap<>();
	//Método para calcular las ganancias. 
	double calcularGanancia (double apuesta, int multiplicador){
		double ganancia = apuesta * multiplicador;
		double redondeado = Math.round(ganancia *100)/100;
		return redondeado;
	}
	//Metodo esPar
	String esPar(int num) {
		if(num % 2 == 0) {
			return "Par";
		} else {
			return "Impar";
		}
		
	}
	//Metodo pasa o falta.
	String pasa(int num){
		if (num > 18) {
			return "Pasa";
		}
	else{
			return "Falta";
		}
	}
	
	//Método Docena 

	String docena(int num){
		if (num <=12 ){
			return "Primera";
		}
		else if (num > 12 && num <=24){
			return "Segunda";
		}
		else{
			return "Tercera";
		}
	}

	//Método Columna 
	//Para este método primero haré muchas condicionales. Es más fácil si utilizo un array con dos dimensiones. Más tarde intentaré mejorarlo. 
	String columna(int num){
		if (num == 1 || num == 4 || num == 7 || num == 10 || num == 13 || num == 16 || 
		num == 19 || num == 22 || num == 25 || num == 28 || num == 31 || num == 34){
			return "Primera";
		}
		else if (num == 2 || num == 5 || num == 8 || num == 11 || num == 14 || num == 17 || 
		num == 20 || num == 23 || num == 26 || num == 29 || num == 32 || num == 35){
			return "Segunda";
		}
		else{
			return	"Tercera";
		} 			
	}
	//Método Series
	String series(int num){
		if (num == 27 || num == 13 || num == 36 || num == 11 || num == 30 || num == 8 || 
		num == 23 || num == 10 || num == 5 || num == 24 || num == 16 || num == 33){
			return "5/8";
		}
		else if (num == 1 || num == 20 || num == 14 || num == 31 || num == 9 || 
		num == 6 || num == 17 || num == 34){
			return "Huerfanos";
		}
		else if (num == 22 || num == 18 || num == 29 || num == 7 || num == 28 || num == 12 || 
		num == 35 || num == 3 || num == 26 || num == 0 || num == 32 || num == 15 || 
		num == 19 || num == 4 || num == 21 || num == 2 || num == 25){
			return "vecinos0";
		}
		else {
			return "0";
		}
	}

	//Metodo Tirar Bolita
	int tirarBolita() {
		
		int numero = random.nextInt(37); //0-36
		
		return numero;
	}
	
	//Metodo imprimir menu
	int menu() {
		System.out.println("Con que te sientes afortunado??");
		System.out.println("Tienes " + saldo + "€");
		System.out.println("1. Rojo");
		System.out.println("2. Negro");
		System.out.println("3. Par");
		System.out.println("4. Impar");
		System.out.println("5. Numero");
		System.out.println("6. Pasa o falta");
		System.out.println("7. Docenas");
		System.out.println("8. Columnas");
		System.out.println("9. Series");
		int opcion = sc.nextInt();
		sc.nextLine();	
		return opcion;
	}	
	//Método submenu para pasa o falta
	int submenupasafalta(){
		
		System.out.println("Elige la siguiente opción: ");
		System.out.println("1. Se queda corto(Falta).");
		System.out.println("2. Se pasa (Pasa).");
		int opcion = sc.nextInt();
		sc.nextLine();
		return opcion;


	}
	//Metodo submenu para docenas. 
	int submenudocenas(){
		System.out.println("¿A qué docena quiere apostar?:");
		System.out.println("1. Primera docena (12 primeros números).");
		System.out.println("2. Segunda docena (13 al 24).");
		System.out.println("1. Tercera docena (25 al 36).");
		int opcion = sc.nextInt();
		sc.nextLine();
		return opcion;
	}
	//Método submenu para columnas
	int submenucolumnas(){
		System.out.println("¿A que columna quiere apsotar?");
		System.out.println("1. Primera columna (1,4,7,10,13,16,19,22,25,28,31,34).");
		System.out.println("2. Segunda columna (2,5,8,11,14,17,20,23,26,29,32,35).");
		System.out.println("3. Tercera columna (3,6,9,12,15,18,21,24,27,30,33,36).");
		int opcion = sc.nextInt();
		sc.nextLine();
		return opcion;
	}
	//método submenu para series

	int submenuseries(){
		System.out.println("¿A qué serie quiere apostar?");
		System.out.println("1. Serie 5/8");	
		System.out.println("2. Serie Huerfanos ");
		System.out.println("3. Serie Vencios del 0");
		System.out.println("4. Serie juegos del 0");	
		int opcion = sc.nextInt();
		sc.nextLine();
		return opcion;
	}
	//Metodo conseguir apuesta
	double conseguirApuesta() {
		System.out.println("Cuanto dinero quieres apostar? ");
		double apuesta = sc.nextDouble();
		if (apuesta <= saldo && apuesta >= 0) {
			saldo -= apuesta;
			return apuesta;
		} else {
			System.out.println("No tienes ese dinero fantasma");
			conseguirApuesta();
		}
		return 0;
	}

	//Método para poder volver a apostar más adelante. 
	String Respuesta() {
		String respuesta;
		System.out.println("Le gustaría hacer alguna otra apuesta? (Si/No)");
		respuesta = sc.nextLine();
		if (respuesta.equals("Si") || respuesta.equals("No")){
			return respuesta;
		}
		else {
			System.out.println("Lo siento no te he entendido");
			Respuesta();
		}
		return respuesta;
	}

	HashMap<String, Double> actualizarApuestas(HashMap<String, Double> apuestas, int numero) {
		// Condicional Colores
		if (colores[numero].equals("Rojo")) {
			apuestas.remove("Negro");
		} else if (colores[numero].equals("Negro")) {
			apuestas.remove("Rojo");
		} else if (colores[numero].equals("Verde")) {
			apuestas.remove("Rojo");
			apuestas.remove("Negro");
		}
	
		// Condicional Pasa o falta
		if (pasa(numero).equals("Pasa")) {
			apuestas.remove("Falta");
		} else if (pasa(numero).equals("Falta")) {
			apuestas.remove("Pasa");
		}
	
		// Condicionales Docenas
		if (docena(numero).equals("Primera")) {
			apuestas.remove("2D");
			apuestas.remove("3D");
		} else if (docena(numero).equals("Segunda")) {
			apuestas.remove("1D");
			apuestas.remove("3D");
		} else if (docena(numero).equals("Tercera")) {
			apuestas.remove("1D");
			apuestas.remove("2D");
		}
	
		// Condicional Columnas
		if (columna(numero).equals("Primera")) {
			apuestas.remove("2C");
			apuestas.remove("3C");
		} else if (columna(numero).equals("Segunda")) {
			apuestas.remove("1C");
			apuestas.remove("3C");
		} else if (columna(numero).equals("Tercera")) {
			apuestas.remove("2C");
			apuestas.remove("1C");
		}
	
		// Condicional Series
		if (series(numero).equals("5/8")) {
			apuestas.remove("Huerfanos");
			apuestas.remove("vecinos0");
			apuestas.remove("0");
		} else if (series(numero).equals("Huerfanos")) {
			apuestas.remove("5/8");
			apuestas.remove("vecinos0");
			apuestas.remove("0");
		} else if (series(numero).equals("vecinos0")) {
			apuestas.remove("5/8");
			apuestas.remove("Huerfanos");
			apuestas.remove("0");
		} else if (series(numero).equals("0")) {
			apuestas.remove("5/8");
			apuestas.remove("Huerfanos");
			apuestas.remove("vecinos0");
		}
	
		// Devolver el HashMap actualizado
		return apuestas;
	}

	//Programar espera, simplemente una tontada para que me de un efecto visual. 
	public static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida.");
            Thread.currentThread().interrupt(); // Restablece el estado de interrupción
        }
    }
	
	 
	//Metodo principal para jugar
	void jugar() {
		int multiplicador = 0;
		double apuesta = 0;
		int numero = tirarBolita();
		String otra;
		do {
			int opcionApuesta = menu();
			int opcionapuesta2 = 0;
			int opcionapuesta3 = 0;
			int opcionapuesta4 = 0;
			int opcionapuesta5 = 0;
			apuesta = conseguirApuesta();
			
			String tipoapuesta = ""; // Inicializar tipoapuesta
			int n = 0;
			// Creamos un if para cada opción de apuestas y poder elegir de nuevo un menú.
			if (opcionApuesta == 1) {
				tipoapuesta = "Rojo";
				multiplicador = 2; 
				sc.nextLine();
			} else if (opcionApuesta == 2) {
				tipoapuesta = "Negro";
				multiplicador = 2;
				sc.nextLine(); 
			} 
			else if (opcionApuesta == 3 ){
				tipoapuesta = "Par";
				multiplicador = 2;
				sc.nextLine();
			}
			else if (opcionApuesta == 4 ){
				tipoapuesta = "Impar";
				multiplicador = 2;
				sc.nextLine();
			}
			else if (opcionApuesta == 5) {
				System.out.println("Introduce el numero deseado");
				n = sc.nextInt();
				sc.nextLine();
				tipoapuesta = Integer.toString(n);
				multiplicador = 36;
			} else if (opcionApuesta == 6) {
				 // Pasa o falta
				opcionapuesta2 = submenupasafalta();
				if (opcionapuesta2 == 1){
				tipoapuesta = "Falta";
				multiplicador = 2; 
				}
				else {
					tipoapuesta = "Pasa";
					multiplicador = 2;
				}
			} else if (opcionApuesta == 7) { // Docenas
				opcionapuesta3 = submenudocenas();
				if (opcionapuesta3 == 1){
					tipoapuesta = "1D";
					multiplicador = 3;
				}
				else if (opcionapuesta3 == 2){
					tipoapuesta = "2D";
					multiplicador = 3;
				}
				else {
					tipoapuesta = "3D";
					multiplicador = 3;
				}
				
			} else if (opcionApuesta == 8) { // Columnas
				opcionapuesta4 = submenucolumnas();
				if (opcionapuesta4 == 1){
					tipoapuesta = "1C";
					multiplicador = 3; 
				}
				else if (opcionapuesta4 == 2){
					tipoapuesta = "2C";
					multiplicador = 3; 
				}
				else {
					tipoapuesta = "3C";
					multiplicador = 3; 
				}
				
			} else if (opcionApuesta == 9) { // Series
				opcionapuesta5 = submenuseries();
				if (opcionapuesta5 == 1) {
					apuesta /= 12; // Utilizar el /= es lo mismo que apuesta = apuesta/12
					multiplicador = 17;
					tipoapuesta = series(numero);
				} else if (opcionapuesta5 == 2) {
					apuesta /= 8;
					multiplicador = 35;
					tipoapuesta = series(numero);
				} else if (opcionapuesta5 == 3) {
					apuesta /= 17;
					multiplicador = 11;
					tipoapuesta = series(numero);
				} else if (opcionapuesta5 == 4) {
					apuesta /= 7;
					multiplicador = 17;
					tipoapuesta = series(numero);
				}
			}
		//Guardamos la apuesta en el hashmap
		apuestas.put(tipoapuesta, calcularGanancia(apuesta, multiplicador));
		System.out.println("Apuestas realizadas: ");
		System.out.println(apuestas);
		otra = Respuesta();
		} while (otra.equals("Si") && saldo >0);
	
	//Mostrar mensaje de Dinero total apostado.

	//Discriminación de colores y par/impar, columnas, docenas y serires utilizando el método actualizar apuesta. 
	apuestas = actualizarApuestas(apuestas, numero);
	System.out.println("No va más.");
	System.out.println("Tiro la bolita.....");
	System.out.println("La bola esta girando ");
	System.out.print(". ");
	esperar(1000);
	System.out.print(". ");
	esperar(1000);
	System.out.print(". ");
	esperar(1000);
	System.out.print(". ");
	esperar(1000);
	System.out.print(". ");
	esperar(1000);
	System.out.println("");
	System.out.println("Ha salido el "+ numero+" "+colores[numero] + " " + esPar(numero));
		
	//Muestra si esta bien realizado la función actualizarApuestas.
	System.out.println(apuestas);
	//Calcular el total ganado en al tirada. 
	double totalganado = 0;
	for (double ganancias : apuestas.values()){
		totalganado += ganancias;
	}
		//Mensaje después tirada. 
		
	if (totalganado == 0){
		System.out.println("Lo siento, pierde.");
	}
	else{
		System.out.println("¡Ha ganado!:  "+ totalganado);
		saldo += totalganado;
	}
	System.out.println("Saldo restante: "+ saldo); 
	}
	
	
 
}
 
public class RuletaV3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double saldoInicial = 1000;
		
		Ruleta rule1 = new Ruleta(saldoInicial);// Ruleta(1000.00)
		
		Seguirjugando seguir = new Seguirjugando();
		//Pongo el mensaje de bienvenida mejor aquí para que cadavez que se realice una apuesta no vuelva a aparecer. 
		System.out.println("Bienvenido a la RuletaV3!!");
		
		//Método seguir jugando
		do{
			rule1.jugar();
		}while(seguir.Seguirjugando().equals("Si"));
		//Mensaje de despedida. 
		System.out.println("¡Hasta pronto!");
		sc.close();
	}
}


 
 
 
 
 
 
 