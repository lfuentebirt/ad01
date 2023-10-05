package Ejercicio2;
/*
 * 2. Flujos de caracteres: (BufferedReader, BufferedWriter) (1,5 puntos)
Realiza un programa en Java que lea un fichero de texto y cree un nuevo fichero con las 
palabras palíndromas que encuentre. Es decir, si el fichero original contiene la frase “ana y 
lola son amigas”, el fichero resultante contendrá las palabras “ana” e “y”. Una palabra 
palíndroma es aquella que se lee igual de izquierda a derecha que de derecha a izquierda. 
 */

// importar paquetes
import java.io.*;

public class Ejercicio2 {
	public static void main(String[] args) {
		// Creamos la instancia del fichero y su ruta
		String ruta = "." + File.separator + "src" + File.separator + "Ejercicio2" + File.separator + "ficheroE2.txt";
		String rutaPalindromas = "." + File.separator + "src" + File.separator + "Ejercicio2" + File.separator + "ficheroE2Palindromas.txt";
		File fichero = new File(ruta);
		File ficheroPalindromas = new File(rutaPalindromas);

		try {
			BufferedReader bf = new BufferedReader(new FileReader(fichero));

			String linea = bf.readLine(); // leemos la linea
			String[] palabras = linea.split("\\s+"); // visto en IA - dividimos en palabras
			int[] quitar = new int[palabras.length]; // quitamos las palabras en cuya posicion haya un 1
			char[] palabraArray; // guardamos en cada posicion un caracter de la palabra
			String alreves = "";// guardamos la palabra escrita alreves

			while (linea != null) {
				palabras = linea.split("\\s+");
				for (int i = 0; i < palabras.length; i++) {
					palabraArray = palabras[i].toCharArray();// hacemos un array de cada palabra

					for (int j = 1; j < palabras[i].length() + 1; j++) {
						alreves = alreves + palabraArray[palabras[i].length() - j]; // creamos la palabra alreves
					}
					if (!alreves.equals(palabras[i])) { // comparamos
						quitar[i] = 1;
					}
					alreves = "";
				}
				linea = bf.readLine();
				bf.close();

				BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroPalindromas));

				if (ficheroPalindromas.exists()) { // si existe, lo borramos
					ficheroPalindromas.delete();
				}
				if (ficheroPalindromas.createNewFile()) {
					System.out.println("El fichero se ha creado correctamente");
				}

				for (int i = 0; i < palabras.length; i++) {//añadimos las palabras
					if (quitar[i] != 1) {
						bw.write(palabras[i] + " ");
					}
				}
				bw.close(); // cerramos el fichero
			}
		} catch (FileNotFoundException e) { // gestionamos las posibles excepciones
			System.out.println("Error. Fichero no encontrado " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al leer el fichero " + e.getMessage());
		}
	}
}
