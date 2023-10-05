package Ejercicio4;
/*
 * Realiza un programa en Java que te permita visualizar los personajes de un tipo concreto (héroe o villano).
 *  El programa recibe desde la línea de comandos el tipo de personaje y visualiza cuantos personajes hay de dicho tipo
 *   y todos los datos de dichos personajes. Verifica que exista dicho tipo en el fichero, si no existe saca un mensaje de error
 *    por pantalla. (1,5 puntos) Nota: Hay que pensar que el fichero puede crecer en un futuro y aparecer nuevos tipos
 */

//importamos el paquete
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4c {
	public static void main(String[] args){
		final int longitud = 110; //Longitud del registro  4 + 18 + 20 + 40 + 20 + 4 + 4
		String ruta = "." + File.separator + "src" + File.separator + "Ejercicio4" + File.separator + "Marvel.dat";
		File fichero = new File(ruta);
		
		Scanner consola = new Scanner(System.in);  // lectura por consola y datos obtenidos
		
		String tipoConsola;
		List<Personaje> personajes = new ArrayList<>();
		
		char[] dni = new char[9];
		char[] nombre = new char[10];
		char[] identidad = new char[20];
		char[] tipo = new char[10];
		
		try {
			RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "r");
			
			// leemos por consola
			System.out.println("Introduce un tipo de personaje:");    
			tipoConsola = consola.nextLine();	
			
			
			for(int i = 0 ; i < fichero.length(); i += longitud){ // recorremos el fichero
				ficheroAleatorio.seek(i);
				
				Personaje pers = new Personaje();
				pers.setId(ficheroAleatorio.readInt());
				
				for(int j = 0; j < 9; j++) { // guardamos el DNI
					dni[j] = ficheroAleatorio.readChar();
				}
				
				pers.setDNI(new String(dni).trim()); 
				
				
				for(int z = 0; z < 10; z++) { // nombre
					nombre[z] = ficheroAleatorio.readChar();
				}
				
				pers.setNombre(new String(nombre).trim());
				
				for(int y = 0; y < 20; y++) { // identidad
					identidad[y] = ficheroAleatorio.readChar();
				}
				
				pers.setIdentidad(new String(identidad).trim());
				
				for(int x = 0; x < 10; x++) { // tipo
					tipo[x] = ficheroAleatorio.readChar();
				}
				
				pers.setTipo(new String(tipo).trim());
				
				pers.setPeso(ficheroAleatorio.readInt()); // leemos el peso
				
				pers.setAltura(ficheroAleatorio.readInt()); // leemos la altura
				
				if(pers.getTipo().equals(tipoConsola)) {
					personajes.add(pers);
				}
			}
			
			if(personajes.size() > 0) {
				System.out.println("Se han encontrado " + personajes.size() + " " + tipoConsola + "s");
				for(Personaje p : personajes) {
					System.out.println(p.toString());
				}
			}else {
				System.out.println("No existen " + tipoConsola + "s en el fichero.");
			}
			
			ficheroAleatorio.close(); // cerramos el fichero

		} catch (FileNotFoundException e) {
			System.out.println("Error. No se ha encontrado el fichero " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al cargar los personajes en el fichero " + e.getMessage());
		}
	}
}
