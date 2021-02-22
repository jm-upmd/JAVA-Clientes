package clientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		final String F_ENTRADA = "H:\\Cursos Actuales\\Curso Java\\Proyectos Eclipse\\Practica Clientes\\Clientes.txt";		
		final String F_SALIDA = "H:\\Cursos Actuales\\Curso Java\\Proyectos Eclipse\\Practica Clientes\\ClientesSalida.txt";		


		// Para guardar todos los objetos Cliente
		ArrayList<Cliente> listaClientes = new ArrayList<>();

		
		leeClientes(listaClientes, F_ENTRADA);

		// Muestra clientes de España
		System.out.println("*** CLIENTES DE ESPAÑA ***");
		muestraPorNacionalidad(listaClientes);

		System.out.println("\n\n************************\n");

		// Muestra clientes de Alemania
		System.out.println("*** CLIENTES DE ALEMANIA ***");

		muestraPorNacionalidad(listaClientes, "Alemania");
		
		
		System.out.println("\nGrabando clientes en fichero:" + F_SALIDA);
		
		
		grabaClientes(listaClientes, F_SALIDA);

	} // fin main()

	static void leeClientes(ArrayList<Cliente> lista, String fichero) {

		
		// Crea objeto File con el nombre de fichero a leer
		File f = new File(fichero);
		
		// Creo instancia de Scanner para leer del fichero
		Scanner scnr = null;
		try {
			scnr = new Scanner(f); // Se le pasa como parametro el objeto File

			// Leyendo líneas del fichero con Scanner

			while (scnr.hasNextLine()) { // Mientras queden líneas por leer
				String linea = scnr.nextLine(); // Lee linea

				// Ejecuta método creaObjetoCliente pasando la linea leída como parámetro
				// creaObjetoCliente devuelve el objeto Cliente creado a partir de linea
				// El objeto devuelto es añadido al ArrayList listaClientes

				lista.add(creaObjetoCliente(linea));
				System.out.println("Creado objeto cliente...");
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero: " + f.getAbsolutePath());
			System.exit(0);

		} finally {
			// El objeto Scanner lo cierro aquí, pues este bloque se ejecutará siempre
			// haya o no excepción.
			if (scnr != null) scnr.close();
		}
	}

	static void grabaClientes(ArrayList<Cliente> clientes, String fichero) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(fichero);

			/*
			 * Para añadir al final de un fichero ya existente FileWriter fichero = new
			 * FileWriter("c:/fichero.txt",true);
			 */
			pw = new PrintWriter(fw);

			for (Cliente c : clientes) {
				pw.println(c.objetoAString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally { // finally siempre se ejecuta tras el try haya o no excepción
			try {
				// En el finally para nos asegurarnos que se cierra el fichero.
				if (fw != null)
					fw.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

	}

	private static Cliente creaObjetoCliente(String linea) {

		// Divide la linea en trozos utilizando ";" como caracter separador
		// Cada trozo lo guarda en una posición del array tokens
		String[] tokens = linea.split(";");
		
		// Comvierto los datos de los campos antiguedad y facturación a sus respectivos tipos númericos.
		
		int antiguedad=0;
		float facturacion=0;
		try {
			antiguedad = Integer.parseInt(tokens[3]);
		} catch (NumberFormatException e) {
			System.out.println("No se ha podido covertir a número el valor del campo antiguedad: " + tokens[3]);
			System.exit(-1);
		}
		
		try {
			facturacion = Float.parseFloat(tokens[4].replace(',', '.')); // En fichero origen el simbolo de dicimal me viene como coma.
																		 // y tiene que ser punto porque sino fallaría.
		} catch (NumberFormatException e) {
			System.out.println("No se ha podido covertir a número el valor del campo Facturación: " + tokens[4]);
			System.exit(-1);
		}
		
		Cliente cliente = new Cliente(tokens[0], tokens[1], tokens[2], antiguedad, facturacion, 
				tokens[5], tokens[6], tokens[7], tokens[8], tokens[9], tokens[10], tokens[11],tokens.length == 13 ? tokens[12] : "");

		return cliente;
	}

	// Muestra información de clientes de España
	private static void muestraPorNacionalidad(ArrayList<Cliente> lista) {
		int totClientes = 0;
		float totFacturacion = 0;
		final char TAB = '\t';

		for (Cliente c : lista) {
			if (c.esEspañol()) {
				System.out.println("Registro " + ++totClientes);
				System.out.println(TAB + "Id. Cliente: " + c.getIdCliente());
				System.out.println(TAB + "Nombre Contacto: " + c.getNombreContacto());
				System.out.println(TAB + "Antigüedad: " + c.getAntiguedad());
				System.out.println(TAB + "Facturación: " + c.getFacturacion());
				System.out.println(TAB + "Nombre Compañía: " + c.getNombreCompañia());
				System.out.println(TAB + "Nombre Ciudad: " + c.getCiudad() + '\n');
				totFacturacion+=c.getFacturacion();

			}
		}

		System.out.printf("%35s: %20d\n", "Total clientes", totClientes);
		
		// Formato la coma indica que utilize caracteres de agrupación locales
		// 20.2f representa el numero flotante en campo de 20 posiciones y con 2 decimales.
	    System.out.printf("%35s: %,20.2f\n", "Total facturación (€)",totFacturacion);
	}

	// Sobrecarga de muestraPorNacionalidad con parametro adicional para indicar el
	// país
	private static void muestraPorNacionalidad(ArrayList<Cliente> lista, String nac) {
		int totClientes = 0;
		float totFacturacion = 0;
		final char TAB = '\t';

		for (Cliente c : lista) {

			if (c.getPais().toUpperCase().compareTo(nac.toUpperCase()) == 0) {
				System.out.println("Registro " + ++totClientes + " (" + c.getPais() + ")");
				System.out.println(TAB + "Id. Cliente: " + c.getIdCliente());
				System.out.println(TAB + "Nombre Contacto: " + c.getNombreContacto());
				System.out.println(TAB + "Antigüedad " + c.getAntiguedad());
				System.out.println(TAB + "Facturación " + c.getFacturacion());
				System.out.println(TAB + "Nombre Compañía: " + c.getNombreCompañia());
				System.out.println(TAB + "Nombre Ciudad: " + c.getCiudad() + '\n');
				totFacturacion+=c.getFacturacion();
			}
		}
		
		System.out.printf("%35s: %20d\n", "Total clientes", totClientes);
		
		// Formato la coma indica que utilize caracteres de agrupación locales
		// 20.2f representa el numero flotante en campo de 20 posiciones y con 2 decimales.
	    System.out.printf("%35s: %,20.2f\n", "Total facturación (€)",totFacturacion);

	}
	
}
