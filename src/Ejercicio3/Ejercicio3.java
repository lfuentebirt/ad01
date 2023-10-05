package Ejercicio3;
/*
 * 3. (Flujos binarios:InputStream) (1,5 puntos)
	Realiza un programa en Java que lea la cabecera de un fichero ZIP y comprueba si 
	realmente se trata de un fichero ZIP o no. Para que sea un ZIP válido la cabecera debe 
	comenzar con la siguiente secuencia de bytes {80, 75, 3, 4} (1 punto
 * */

//importar paquetes
import java.io.*;

public class Ejercicio3 {
	public static void main(String[] args) {
		// ZIP cabecera 80, 75, 3, 4
		final int[] cabecera = new int[]{80, 75, 3, 4};
		// 1. Instancia del fichero
		String ruta = "." + File.separator + "src" + File.separator + "Ejercicio3" + File.separator + "DAM_AD01_TaEv01.zip";
		File fichero = new File(ruta);
		int contador = 0;
		boolean esZIP = true;
		int numLectura;
		
		// 2. Crear un flujo de salida hacia el fichero
		try(InputStream in = new FileInputStream(fichero)){
			numLectura = in.read();
			while (numLectura != -1) {
				//  3. Comprobar que es ZIP
				if(contador < cabecera.length) {
					if(cabecera[contador] != numLectura) {
						esZIP = false;
					}
				}
				//System.out.println(x);
				numLectura = in.read();
				contador++;
			}
			// 4. Mostramos por consola el resultado
			if(esZIP) {
				System.out.println("El documento " + fichero.getName() + " es de tipo ZIP");
			}else {
				System.out.println("El documento " + fichero.getName() + " no es de tipo ZIP");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
