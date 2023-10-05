package Ejercicio4;
/*
 * b). Desde la editorial quieren tener controlado el peso de sus personajes, ya que
últimamente han hecho algún exceso que otro. Realiza un programa en java que te permita
modificar los datos de un personaje. El programa recibe desde la línea de comandos el dni
y el peso del último mes. Si el personaje no existe devolverá un mensaje de error, sino
mostrará en la consola el nombre del personaje y cuantos kilos ha engordado, adelgazado o si se 
mantiene en su peso. (1,5 puntos)
 */

//importamos el paquete
import java.io.*;
import java.util.Scanner;

public class Ejercicio4b {
	public static void main(String[] args){
		// instancia del fichero
		final int longitud = 110; //Longitud del registro  4 + 18 + 20 + 40 + 20 + 4 + 4
		String ruta = "." + File.separator + "src" + File.separator + "Ejercicio4" + File.separator + "Marvel.dat";
		File fichero = new File(ruta);
		
		Scanner consola = new Scanner(System.in);  // lectura por consola y datos obtenidos
		String dniConsola; 
		int pesoConsola;
		
		char[] dniLectura = new char[9];  // lectura del fichero y datos obtenidos
		char[] nombreLectura = new char[10];
		int pesoLectura = 0;
		
		String nombre = new String(); // para convertir char[] a string
		String dniString;
		
		boolean existe = false; // que exista el superheroe
		int diferencia = 0;
		int posicion = 0;
		
		try {
			RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "rw");
			// leemos por consola
			System.out.println("Introduzca el DNI (con letra) del personaje para el control del peso:");    
			dniConsola = consola.nextLine();
			System.out.println("Introduzca su peso actual:");    
			pesoConsola = consola.nextInt();		
			
			for(int i = 0 ; i < ficheroAleatorio.length(); i += longitud){ // recorremos el fichero
				ficheroAleatorio.seek(i);
				ficheroAleatorio.read();
				
				for(int j = 0; j < 9; j++) { // guardamos el DNI
					dniLectura[j] = ficheroAleatorio.readChar();
				}
				
				dniString = new String(dniLectura).trim(); // lo convertimos a string
				
				if(dniString.equals(dniConsola)) { // verificamos si existe
					existe = true;
					
					for(int z = 0; z < 10; z++) { // obtenemos el nombre para el mensaje
						nombreLectura[z] = ficheroAleatorio.readChar();
					}
					
					nombre = new String(nombreLectura).trim();
					ficheroAleatorio.skipBytes(60); 
					pesoLectura = ficheroAleatorio.readInt(); // leemos el peso
					
					ficheroAleatorio.seek(i + 102); // posicionamos en el peso para poder actualizar
					
					diferencia = pesoLectura - pesoConsola; // calculamos la diferencia
					break;
				} 
			}
			
			
			if(existe) {
				if(diferencia != 0) { 
					ficheroAleatorio.writeInt(pesoConsola); // cambiamos el peso si hay diferencia
					
					if(diferencia > 0) {
						System.out.println(nombre + " ha adelgazado " + diferencia + " kilos.");
					}else if (diferencia < 0) {
					System.out.println(nombre + " ha engordado " + (-diferencia) + " kilos.");
					}
				}else {
					System.out.println(nombre + " se mantiene en su peso anterior.");
				}
			}else {
				System.out.println("Error. El personaje no existe");
			}
			ficheroAleatorio.close(); // cerramos el fichero

		} catch (FileNotFoundException e) {
			System.out.println("Error. No se ha encontrado el fichero " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al cargar los personajes en el fichero " + e.getMessage());
		}
	}

}
