package app.clothesstore.productos.store.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import app.clothesstore.productos.model.dto.ProductoDTO;

public interface IStoreService {
	
	public Page<ProductoDTO> getProductos(Pageable pageable);
	public ProductoDTO getProducto(long id);

}
