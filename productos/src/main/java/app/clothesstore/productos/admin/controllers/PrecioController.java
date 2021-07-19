package app.clothesstore.productos.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.clothesstore.productos.admin.services.impl.PrecioService;
import app.clothesstore.productos.exceptions.ObjectAllreadyExistException;
import app.clothesstore.productos.exceptions.ObjectNoFoundException;
import app.clothesstore.productos.model.entities.Precio;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin/precios")
public class PrecioController {
	
	
	@Autowired
	private PrecioService precioService;
	
	@GetMapping("/{idProducto}")
	public Page<Precio> getPrecios(Pageable pageable, @PathVariable("idProducto")long idProducto) {
		return precioService.listar(idProducto, pageable);
	}
	
	@PostMapping("/create")
	public void crearPrecio(@RequestBody Precio precio) throws ObjectAllreadyExistException {
		precioService.crear(precio);
	}
	
	@PutMapping("/update")
	public void actualizarPrecio(@RequestBody Precio precio) throws ObjectNoFoundException {
		precioService.actualizar(precio);
	}

}
