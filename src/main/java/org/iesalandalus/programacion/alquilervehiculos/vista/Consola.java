package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {
	}

	public static void mostrarCabecera(String mensaje) {
		StringBuilder lineas = new StringBuilder();
		for (int i = 0; i < mensaje.length(); i++) {
			lineas.append("-");
		}
		System.out.printf("%n%s%n%s%n", mensaje, lineas);
	}

	public static void mostrarMenu() {
		mostrarCabecera("OPCIONES");
		for (Opcion opcion : Opcion.values()) {
			System.out.println(opcion);
		}
		System.out.println("");
	}

	private static String leerCadena(String mensaje) {
		System.out.print(mensaje);
		return Entrada.cadena();
	}

	private static Integer leerEntero(String mensaje) {
		System.out.print(mensaje);
		return Entrada.entero();
	}

	private static LocalDate leerFecha(String mensaje) {
		System.out.print(mensaje);
		LocalDate fecha = null;
		try {
			fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
		} catch (DateTimeParseException e) {
			System.out.printf("%s", e.getMessage());
		}
		return fecha;
	}

	public static Opcion elegirOpcion() {
		int indiceOpcion = 0;
		do {
			indiceOpcion = leerEntero("Dime una opción: ");
		} while ((indiceOpcion < 0) && (indiceOpcion > 17));
		return Opcion.values()[indiceOpcion];
	}

	public static Cliente leerCliente() {
		return new Cliente(leerNombre(), leerCadena("Dimeme un DNI: "), leerTelefono());
	}

	public static Cliente leerClienteDni() {
		return Cliente.getClienteConDni(leerCadena("Dimeme un DNI: "));
	}

	public static String leerNombre() {
		return leerCadena("Dime el nombre del cliente: ");
	}

	public static String leerTelefono() {
		return leerCadena("Dime un teléfono del cliente: ");
	}

	public static Turismo leerTurismo() {
		return new Turismo(leerCadena("Dime la marca del turismo: "), leerCadena("Dime el modelo del turismo: "),
				leerEntero("Dime las cilindradas del turismo: "), leerCadena("Dime la matricula: "));
	}

	public static Turismo leerTurismoMatricula() {
		return Turismo.getTurismoConMatricula(leerCadena("Dime una matricula: "));
	}

	public static Alquiler leerAlquiler() {
		return new Alquiler(leerClienteDni(), leerTurismoMatricula(), leerFecha("Dime una fecha de alquiler: "));
	}

	public static LocalDate leerFechaDevolucion() {
		return leerFecha("Dime una fecha de devolucion: ");
	}

}
