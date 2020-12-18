## Desarrollo de una API REST con Spring Boot

## Descripción

Desarrollo de una API REST en Java con Spring Boot.  
Spring es un framework para el desarrollo de aplicaciones y contenedor de inversión de control, de código abierto para la plataforma Java.  Un servicio REST es un nuevo enfoque propuesto por Roy Fielding en su tesis doctoral.  
Características:  
- Basado en el protocolo HTTP
- Sin estados
- Representados por una URI
- Interfaz uniforme
- Sistema de capas

REST está orientado al concepto de recurso y cada recurso debe ser accesible a través de una URI.  
El servidor puede ofrecer diferentes representaciones de un mismo recurso (por ejemplo en XML, JSON o HTML).

Ventajas del uso de REST
- Separación cliente - servidor
- Visibilidad, fiabilidad y escalabilidad
- Heterogeneidad
- Variedad de formatos: JSON, XML, ...
- En general, es más rápido y utiliza menos ancho de banda

## Testear con cliente Postman

**Petición para mostrar todos los productos**  

Se muestra una lista con todos los productos de la base de datos.

!["](/files/listar-productos.png)

**Petición para mostrar todos los productos ordenados**  
Se muestra una lista con todos los productos ordenados por el campo ***categoria*** de la base de datos.

!["](/files/productos-ordenados.png)

**Petición para insertar un producto**  

Se inserta un nuevo producto la base de datos.

!["](/files/insertar.png)

**Petición para comprobar la inserción de un producto**  

Comprobar la inserción un nuevo producto la base de datos.

!["](/files/comprobar-insertar.png)

**Petición para buscar y mostrar un producto por su ID**  

Se busca y se muestra un producto por su ID en base de datos.

!["](/files/producto.png)

**Petición para actualizar un producto**  

Se actualiza un producto de la base de datos.

!["](/files/actualizar.png)

**Petición para comprobar la actualización de un producto**  

Comprobar la actualización un producto de la base de datos.  
Se ha actualizado el precio de 270€ a 300€

!["](/files/comprobar-actualizar.png)

**Petición para eliminar un producto**  

Se elimina un producto de la base de datos.

!["](/files/eliminar.png)

**Petición para comprobar que se ha eliminado el producto**  

Se elimina un producto de la base de datos.

!["](/files/comprobar-eliminar.png)

## Documentar API

Una API que no está documentada, posiblemente sea difícil de utilizar.
No todo el mundo entiende lo mismo por REST.  
En ocasiones, se implementan reglas de validación que nos obligan a utilizar tipos de datos concretos.  

## ¿Cómo crear esta documentación?

Para la documentación de esta API REST he utilizado Swagger.

## Swagger

- Swagger es un framework de código abierto respaldado por un gran ecosistema de herramientas que ayuda a los desarrolladores a
diseñar, construir, documentar y consumir servicios web RESTful.
- Una de las más utilizadas es Swagger UI tool.
- Swagger es una serie de reglas, especificaciones y herramientas que nos ayudan a documentar nuestras APIs.
- Utiliza un json que incluye toda la documentación de nuestra API  

## Swagger UI

Ejecutar la aplicación 

Abrir en el navegador [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Es capaz de transformar ese JSON y hacerlo interactivo.

!["](/files/swagger-inicio.png)  

Nos permite probar las peticiones, incluso con nuestros propios datos.

!["](/files/swagger-peticiones.png) 

## ¿Cómo incluir Swagger en el proyecto?  

## Swagger + SpringFox 

- SpringFox es un conjunto de librerías que nos permite generar automáticamente la documentación de nuestra API.
- Es capaz de generar esta documentación en formato Swagger.
- La ventaja es que no tenemos que generar, manualmente, el fichero swagger.json.
- Disponemos de clases y anotaciones para poder afinar la configuración.  

## Dependencias  

- Hay que añadir las siguientes dependencias en el fichero pom.xml  

~~~
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>

<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>
 ~~~
 ## Configuración  
- Anotación @EnableSwagger2 en una clase @Configuration
- Necesitamos un bean de tipo Docket que incluya la configuración para generar la documentación.
- Podemos personalizar el resultado de la documentación.
- Podemos incluir una ApiInfo acorde a nuestro proyecto.

~~~
@Configuration
@EnableSwagger2
public class SwaggerConfiguracion {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.dam.controladores"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	@Bean
	public ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("API DOCUMENTACIÓN")
				.description("DESARROLLO DE UNA API REST CON SPRING BOOT")
				.version("1.0")
				.contact(new Contact("Daniel Pompa Pareja"," ", "example@gmail.com"))
				.build();
	}
}
~~~

## Anotaciones

- Disponemos de algunas anotaciones que nos permiten personalizar determinados aspectos.
- A nivel de método de controlador
	- @ApiOperation: describe qué hace el método del controlador
	- @ApiResponse/s: describen las diferentes respuestas que puede dar dicho método
	- @ApiParam: describen el parámetro que recibe el método
- A nivel de objetos POJO
	- @ApiModelProperty: nos permite personalizar la información que aparece de cada propiedad del modelo
		- Nombre
		- Tipo de dato
		- Valor de ejemplo
		- Posición
