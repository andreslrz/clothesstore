package app.clothesstore.productos.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.clothesstore.productos.model.dto.ProductoDTO;
import app.clothesstore.productos.store.services.IStoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {
	
	@Autowired
	private IStoreService storeService;
	
	@GetMapping("/list")
	public Page<ProductoDTO> getProductos(Pageable pageable) {
		return storeService.getProductos(pageable);
	}
	
	
	@GetMapping("/detail/{id}")
	public ProductoDTO getProducto(@PathVariable("id") long id) {
		return storeService.getProducto(id);
	}

}
