package com.dam.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dam.modelos.Producto;
import com.dam.repositorios.ProductoRepositorio;

/**
 * Clase para implementar los métodos de la Interfaz IProductoServicio. 
 * Le ponemos la anotación @Service que indica que es un servicio. 
 * Mediante la anotación @Autowired inyectaremos ProductoRepositorio, 
 * que lo utilizaremos para poder enviar las peticiones a la base de datos en cada método. 
 * El servicio será el que hará de interemediario entre el DAO y el controlador(La clase que gestionará las peticiones de la API)
 * 
 * @author Daniel Versión 1.0
 */

@Service
public class ProductoServicio implements IProductoServicio {

	/**
	 * Atributos
	 */

	@Autowired
	private ProductoRepositorio daoProducto;

	@Override
	public Producto save(Producto producto) {
		return daoProducto.save(producto);
	}

	@Override
	public List<Producto> findAll() {
		return (List<Producto>) daoProducto.findAll();
	}

	@Override
	public List<Producto> findAllSorted() {
		Sort sort1 = Sort.by("categoria").ascending();
		Sort sort2 = Sort.by("precio").descending();
		Sort sort = sort1.and(sort2);
		return (List<Producto>) daoProducto.findAll(sort);
	}

	@Override
	public Optional<Producto> findById(Long id) {
		// Devuelve un Optional
		return daoProducto.findById(id);
	}

	@Override
	public boolean deleteById(Long id) {
		boolean exito = false;
		if (daoProducto.existsById(id)) {
			daoProducto.deleteById(id);
			exito = true;
		}
		return exito;
	}

	@Override
	public Producto update(Producto producto) {
		return daoProducto.save(producto);
	}

}
