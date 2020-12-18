package com.dam.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase ProductoNotFoundException que extiende de RuntimeException.
 * RuntimeException es la superclase de algunas excepciones que se pueden generar durante el funcionamiento normal de la máquina virtual Java.
 * 
 * @author Daniel Versión 1.0
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNotFoundException extends RuntimeException {

	/**
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public ProductoNotFoundException(Long id) {
		super("El producto con ID " + id + " no está en la base de datos del sistema.");
	}
}
