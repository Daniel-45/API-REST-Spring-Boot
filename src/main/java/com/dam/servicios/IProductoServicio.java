package com.dam.servicios;

import java.util.List;
import java.util.Optional;

import com.dam.modelos.Producto;

/**
 * Interfaz IProductoServicio para los servicios de la aplicación.
 * 
 * @author Daniel Versión 1.0
 */
public interface IProductoServicio {

	/**
	 * Insertar un producto
	 * 
	 * @param producto
	 * @return Producto insertado
	 */
	public Producto save(Producto producto);

	/**
	 * Mostrar todos los productos
	 * 
	 * @return Lista de todos los productos
	 */
	public List<Producto> findAll();

	/**
	 * Mostrar todos los productos ordenados
	 * 
	 * @return Lista de todos los productos ordenados
	 */
	public List<Producto> findAllSorted();

	/**
	 * Buscar un producto por clave
	 * 
	 * @param id
	 * @return Producto
	 */
	public Optional<Producto> findById(Long id);

	/**
	 * Eliminar un producto por clave
	 * 
	 * @param id
	 * @return True o False
	 */
	public boolean deleteById(Long id);

	/**
	 * Actualizar un producto
	 * 
	 * @param producto
	 * @return Producto actualizado
	 */
	public Producto update(Producto producto);

}
