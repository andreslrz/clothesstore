package app.clothesstore.productos.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.clothesstore.productos.admin.services.impl.DescuentoService;
import app.clothesstore.productos.exceptions.ObjectAllreadyExistException;
import app.clothesstore.productos.model.entities.Descuento;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin/descuentos")
public class DescuentoController {

	@Autowired
	private DescuentoService descuentoService;
	
	@PostMapping("/new")
	public void crearDescuento(@RequestBody Descuento descuento) throws ObjectAllreadyExistException {
		descuentoService.crearDescuento(descuento);
	}
	
	
}
