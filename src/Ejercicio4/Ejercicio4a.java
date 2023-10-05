package Ejercicio4;
/*
 * 4. (Acceso Aleatorio: RandomAccessFile) 
Desde la editorial Marvel te han contratado para hacer una aplicación que gestione los datos de sus superhéroes y 
supervillanos. Para almacenar la información han decidido utilizar ficheros de distintas clases.
a). Realiza un programa en java para guardar datos de personajes en un fichero aleatorio, dale el nombre 
Marvel.dat. Introduce la información de los personajes a partir de los arrays que se te proporcionan en la 
plataforma Moodle. Cuando termine de realizar la carga de datos deberá informar al usuario de que la carga se ha 
realizado satisfactoriamente o no. Los datos por cada personaje son: (1,5 puntos)
 */

//importamos el paquete
import java.io.*;

public class Ejercicio4a {
	public static void main(String[] args){
		final int longitud = 110; //Longitud del registro  4 + 18 + 20 + 40 + 20 + 4 + 4
		// instancia del fichero, si existe, lo borramos
		String ruta = "." + File.separator + "src" + File.separator + "Ejercicio4" + File.separator + "Marvel.dat";
		File fichero = new File(ruta);
		
		if(fichero.exists()){
			fichero.delete();
		}
		
		try {
			RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "rw");
			
			 // arrays de la tarea
			int [] ids= {1, 2, 3, 4, 5, 6, 7};
			String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
			String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
			String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
			String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
			int[] pesos = {76,84,66,136,78,102,70};
			int[] alturas = {178,183,156,152,177,182,188};
			
			
			StringBuffer bufferDnis = null;
			StringBuffer bufferNoms = null;
			StringBuffer bufferIdentidades = null;
			StringBuffer bufferTipos = null;
			int total = ids.length;
			int contador = 0;
					
			for (int i = 0; i < total; i++){
				contador = i * longitud;
				ficheroAleatorio.seek(contador);
				
				ficheroAleatorio.writeInt(ids[i]);
				
				bufferDnis = new StringBuffer(dnis[i]);      
				bufferDnis.setLength(9); 
				ficheroAleatorio.writeChars(bufferDnis.toString());
				
				bufferNoms = new StringBuffer(noms[i]);     
				bufferNoms.setLength(10); 
				ficheroAleatorio.writeChars(bufferNoms.toString());
				
				bufferIdentidades = new StringBuffer(identidades[i]);      
				bufferIdentidades.setLength(20); 
				ficheroAleatorio.writeChars(bufferIdentidades.toString());
				
				bufferTipos = new StringBuffer(tipos[i]);      
				bufferTipos.setLength(10); 
				ficheroAleatorio.writeChars(bufferTipos.toString());
				
				ficheroAleatorio.writeInt(pesos[i]);
				ficheroAleatorio.writeInt(alturas[i]);
			 }     
			ficheroAleatorio.close();

			System.out.println("La carga de los personajes ha terminado correctamente");
			
		} catch (FileNotFoundException e) {
			System.out.println("Error. No se ha encontrado el fichero " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al cargar los personajes en el fichero " + e.getMessage());
		}
	}
}
