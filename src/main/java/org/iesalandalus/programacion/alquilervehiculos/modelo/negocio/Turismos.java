package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {
	private List<Cliente> coleccionAlquileres;
	public Turismos(){
		coleccionAlquileres = new ArrayList<>();
	}
	public List<Turismo> get(){
		return new ArrayList<>(coleccionAlquileres);		
	}
}
