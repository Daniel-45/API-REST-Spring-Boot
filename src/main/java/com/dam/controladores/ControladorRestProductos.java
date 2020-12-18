package com.dam.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam.error.ProductoNotFoundException;
import com.dam.modelos.Producto;
import com.dam.servicios.IProductoServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * Clase para cargar los datos de los productos y realizar las operaciones CRUD.
 * 
 * @author Daniel
 *
 */

@RestController
@RequestMapping("productos")
public class ControladorRestProductos {

	/**
	 * Atributos
	 */
	private IProductoServicio servicio;

	/**
	 * Constructor
	 * 
	 * Iyencción de dependencias por constructor de la Interfaz IProductoServicio.
	 */
	public ControladorRestProductos(IProductoServicio servicio) {

		this.servicio = servicio;

		cargarDatos();
	}

	/**
	 * Carga datos de los productos
	 */
	private void cargarDatos() {
		servicio.save(new Producto(1L, "Tableta de chocolate Leche Mangaro 50% de cacao", 5.50f, "Dulces"));
		servicio.save(new Producto(2L, "Tableta de chocolate Negro bio 70% de cacao", 5.50f, "Dulces"));
		servicio.save(new Producto(3L, "Pack galletas Shortbread Selection Cartwright & Butler", 18.65f, "Dulces"));
		servicio.save(new Producto(4L, "Galletas Charlotte de chocolate con avellanas", 5.20f, "Dulces"));
		servicio.save(new Producto(5L, "Sirope de Arce Club del Gourmet", 8.50f, "Siropes"));
		servicio.save(new Producto(6L, "Mermelada de fresa Club del Gourmet", 4.50f, "Mermeladas"));
		servicio.save(new Producto(7L, "Jamón de Bellota 100% Ibérico Club del Gourmet", 490f, "Jamones"));
		servicio.save(new Producto(8L, "Lomo de bellota 100% Ibérico Club del Gourmet", 40f, "Embutidos"));
		servicio.save(new Producto(9L, "Chorizo cular 100% Ibérico extra de bellota Club del Gourmet", 20f, "Embutidos"));
		servicio.save(new Producto(10L, "Estuche 4 botellas de aceite de oliva virgen extra", 45f, "Aceites"));
		servicio.save(new Producto(11L, "Aceite de nueces La Tourangelle", 7.50f, "Aceites"));
		servicio.save(new Producto(12L, "Foie gras de pato Club del Gourmet", 14.90f, "Patés"));
		servicio.save(new Producto(13L, "Paté de hongos con trufa blanca", 4.50f, "Patés"));
		servicio.save(new Producto(15L, "Paté Ibérico de Bellota", 6.50f, "Patés"));
		servicio.save(new Producto(16L, "Queso parmesano", 10.75f, "Quesos"));
		servicio.save(new Producto(17L, "Queso Manchego Gran Reserva", 13.70f, "Quesos"));
		servicio.save(new Producto(18L, "Queso mascarpone", 10.80f, "Quesos"));
		servicio.save(new Producto(19L, "Ternera para tacos Gourmet", 10.50f, "Carnes"));
		servicio.save(new Producto(20L, "Tallarines de trigo Soba Somen orgánicos", 8.20f, "Pastas"));
		servicio.save(new Producto(21L, "Tallarines de arroz integral orgánico 100% sin gluten", 5.76f, "Pastas"));
		servicio.save(new Producto(22L, "Arroz bomba Illa Riu", 8.95f, "Arroces"));
		servicio.save(new Producto(23L, "Risotto con setas Gli Aironi", 6.20f, "Arroces"));
		servicio.save(new Producto(24L, "Arroz basmati Club del Gourmet", 5.20f, "Arroces"));
		servicio.save(new Producto(25L, "Risotto con trufa Gli Aironi", 8.20f, "Arroces"));
		servicio.save(new Producto(26L, "Té verde con mezcla de jazmín Club del Gourmet", 10.40f, "Tés"));
		servicio.save(new Producto(27L, "Té rojo con mezcla de jazmín Club del Gourmet", 8.20f, "Tés"));
		servicio.save(new Producto(28L, "Café molido tueste natural Brasil Sul Minas Club del Gourmet", 9.20f, "Cafés"));
		servicio.save(new Producto(29L, "Café en grano tueste natural 100% Arábica origen Kenya Club del Gourmet", 11.50f, "Cafés"));
		servicio.save(new Producto(30L, "Zumo natural de mandarina y romero Club del Gourmet", 2.80f, "Zumos"));
		servicio.save(new Producto(31L, "Zumo natural de naranja Club del Gourmet", 2.20f, "Zumos"));
		servicio.save(new Producto(32L, "Zumo cocktail de frutas rojas ecológicas Club del Gourmet", 6.50f, "Zumos"));
		servicio.save(new Producto(33L, "Cacao puro 100% Club del Gourmet", 9.50f, "Cacaos"));
		servicio.save(new Producto(34L, "Whisky escocés Ardbeg Corryvreckan", 92.90f, "Whisky"));
		servicio.save(new Producto(35L, "Whisky escocés The Macallan 25 años single malt", 1595f, "Whisky"));
		servicio.save(new Producto(36L, "Ginebra Reserve Burrough's Beefeatert", 71.90f, "Ginebra"));
		servicio.save(new Producto(37L, "Ron Zacapa Royal", 285.40f, "Ron"));
		servicio.save(new Producto(38L, "Vodka Grey Goose", 47.95f, "Vodka"));
		servicio.save(new Producto(39L, "Vodka Belvedere Pure botella 6L", 403f, "Vodka"));
		servicio.save(new Producto(40L, "Tequila añejo Don Julio", 155.10f, "Tequila"));
		servicio.save(new Producto(41L, "Tequila joven Casa Dragones 100% Agave azul", 361.70f, "Tequila"));
		servicio.save(new Producto(42L, "Mezcal artesano Grulani 100% Ágave Jabalí", 175f, "Mezcal"));
		servicio.save(new Producto(43L, "Jamón de Bellota 100% Ibérico Cinco Jotas", 255f, "Jamones"));
		servicio.save(new Producto(44L, "Café molido Jamaica Blue Mountain Malongo", 87f, "Cafés"));
		servicio.save(new Producto(45L, "Estuche Jamón Gran Reserva", 590f, "Jamones"));
		servicio.save(new Producto(46L, "Salchichón cular 100% Ibérico extra de bellota Club del Gourmet", 19f, "Embutidos"));

	}

	/**
	 * Mostrar todos los productos
	 * 
	 * @return productos
	 */
	@ApiOperation(value = "Obtener un listado de los productos", notes = "Mecanismo para obtener todos los datos de los productos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Producto.class),
			@ApiResponse(code = 400, message = "Not Found", response = Producto.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Producto.class) })
	@GetMapping("/listar")
	public ResponseEntity<?> obtenerTodos() {

		List<Producto> resultado = servicio.findAll();

		if (resultado.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(resultado);
		}
	}

	/**
	 * Mostrar todos los productos ordenados
	 * 
	 * @return productos
	 */
	@ApiOperation(value = "Obtener un listado de los productos ordenados por categoría", notes = "Mecanismo para obtener todos los datos de los productos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Producto.class),
			@ApiResponse(code = 400, message = "Not Found", response = Producto.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Producto.class) })
	@GetMapping(value = "ordenados")
	public ResponseEntity<?> getAllProductoSorted() {

		List<Producto> resultado = servicio.findAllSorted();

		if (resultado.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(resultado);
		}
	}

	/**
	 * Obtener un producto por su ID
	 * 
	 * @param id
	 * @return mensaje si no encuentra el producto
	 */
	@ApiOperation(value = "Obtener un producto por su ID", notes = "Mecanismo para obtener todos los datos de un producto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Producto.class),
			@ApiResponse(code = 400, message = "Not Found", response = Producto.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Producto.class) })
	@GetMapping("/producto/{id}")
	public Producto obtenerUno(@PathVariable Long id) {
		// Devuelve un Optional
		return servicio.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
	}

	/**
	 * Insertar un nuevo producto
	 * 
	 * @param nuevo
	 * @return producto insertado
	 */
	@ApiOperation(value = "Insertar un producto", notes = "Mecanismo para insertar un producto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Producto.class),
			@ApiResponse(code = 400, message = "Not Found", response = Producto.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Producto.class) })
	@PostMapping("/producto/insertar")
	public ResponseEntity<Producto> nuevoProducto(@RequestBody Producto nuevo) {
		Producto creado = servicio.save(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	/**
	 * Actualizar un producto
	 *
	 * @param producto
	 * @return producto actualizado
	 */
	@ApiOperation(value = "Actualizar un producto", notes = "Mecanismo para actualizar un producto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Producto.class),
			@ApiResponse(code = 400, message = "Not Found", response = Producto.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Producto.class) })
	@SuppressWarnings("unused")
	@PutMapping("producto/actualizar")
	public ResponseEntity<Producto> editarProducto(@RequestBody Producto producto) {
		Producto actualizado = servicio.save(producto);
		return ResponseEntity.ok(servicio.save(producto));
	}

	/**
	 * Borra un producto del catálogo por su ID
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Eliminar un producto por su ID", notes = "Mecanismo para eliminar un producto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Producto.class),
			@ApiResponse(code = 400, message = "Not Found", response = Producto.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Producto.class) })
	@SuppressWarnings("unused")
	@DeleteMapping("producto/eliminar/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
		Producto producto = servicio.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
		servicio.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
