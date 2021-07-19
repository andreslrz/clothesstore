package app.clothesstore.productos.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.clothesstore.productos.admin.services.ICrudService;
import app.clothesstore.productos.exceptions.ObjectAllreadyExistException;
import app.clothesstore.productos.exceptions.ObjectNoFoundException;
import app.clothesstore.productos.model.entities.Producto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin/productos")
public class ProductoController {
	
	@Autowired
	private ICrudService<Producto, Long> productoService;
	
	
	@GetMapping("/list")
	public Page<Producto> listarProductos(Pageable pageable) {
		return productoService.listar(pageable);
	}
	
	@GetMapping("/{id}")
	public Producto buscarProductoPorId(@PathVariable("id")long id) throws ObjectNoFoundException {
		return productoService.buscarPorId(id);
	}
	
	
	@PostMapping("/create")
	public void crearProducto(@RequestBody Producto producto) throws ObjectAllreadyExistException {
		productoService.crear(producto);
	}
	
	@PutMapping("/update")
	public void actualizarProducto(@RequestBody Producto producto) throws ObjectNoFoundException {		
		productoService.actualizar(producto);
	}
	
	
	
	

}
