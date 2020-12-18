package com.dam.repositorios;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam.modelos.Producto;

/**
 * Interfaz ProductoRepositorio. Esta Interfaz extiende de CrudRepository.
 * CrudRepository es la Interfaz para operaciones CRUD genéricas en un repositorio para un tipo específico. 
 * Si queremos alguna operación que no esté incluida en las operaciones CRUD genéricas tenemos que declarar aquí la operación que queremos realizar.
 * Los repositorios en Spring Boot son los DAO 'Data Object Model' para conectarse con nuestra base de datos. 
 * Le ponemos la anotación @Repository que indica que es un DAO.
 * 
 * @author Daniel Versión 1.0
 */

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, Long> {

	/**
	 * Mostrar todos los productos ordenados
	 * 
	 * @param sort
	 * @return Lista de productos ordenados.
	 */
	Iterable<Producto> findAll(Sort sort);

}
