package Ejercicio1;
/*
 * 1. Flujos de caracteres: (FileReader, FileWriter) (1,5 puntos)
Realiza un programa en Java que lea un fichero y lo invierta. Es decir, si
 el fichero de entrada contiene “Hola mundo”, 
 el fichero de salida contendrá “odnum aloH”.
 */
// importamos el paquete
import java.io.*;

public class Ejercicio1 {
	public static void main(String[] args) {
		// Creamos la instancia del fichero y su ruta
		String ruta = "." + File.separator + "src" + File.separator + "Ejercicio1" + File.separator + "ficheroE1.txt";
		File fichero = new File(ruta);
		
		char letra = 0; // cada letra	
		String contenido = "";
		String alreves = ""; // la palabra alreves
		int longitud;
		
		try { 
			// Leemos el fichero
			FileReader fr = new FileReader(fichero);
			
			int valor = fr.read();
			
			while(valor != -1) { // leemos cada caracter
				letra = (char)valor;
				contenido = contenido + letra;
				valor = fr.read();
			}
			
			longitud = contenido.length();
			
			for(int i = 1; i < longitud +1 ; i++) {
				alreves = alreves + contenido.charAt(longitud - i);
			}
			
			fr.close();
			//ahora escribimos en el fichero
			FileWriter fw = new FileWriter(fichero);
			
			char [] arrayAlreves = alreves.toCharArray();
			
			for(int i=0; i<arrayAlreves .length; i++) {
				fw.write(arrayAlreves[i]);  
			}
			
			fw.close();
			 
		} catch (FileNotFoundException e) {
			System.out.println("Error. Fichero no encontrado " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al leer el fichero " + e.getMessage());
		}
		
	}
}
