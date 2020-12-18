package com.dam.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * La clase Producto es entidad que puede ser persistida o seleccionada por JPA.
 * Tiene los atributos de un producto 'nombre, precio y categoría' 
 * Utilizaremos las @anotaciones JPA para relacionarla con nuestra tabla PRODUCTOS.
 * 
 * @author Daniel Versión 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "PRODUCTOS")
public class Producto {

	/**
	 * Atributos de la clase
	 */

	@ApiModelProperty(value = "ID del producto", dataType = "long", example = "1", position = 1)
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@ApiModelProperty(value = "Nombre del producto", dataType = "String", example = "Jamón Ibérico de Bellota", position = 2)
	private String nombre;

	@ApiModelProperty(value = "Precio del producto", dataType = "float", example = "255.50", position = 3)
	private float precio;

	@ApiModelProperty(value = "Categoria del producto", dataType = "String", example = "Embutidos", position = 4)
	private String categoria;

}
