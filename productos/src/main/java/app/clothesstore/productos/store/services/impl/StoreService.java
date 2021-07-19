package app.clothesstore.productos.store.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import app.clothesstore.productos.model.dto.ProductoDTO;
import app.clothesstore.productos.store.repositories.IStoreJdbcRepository;
import app.clothesstore.productos.store.services.IStoreService;

@Service
public class StoreService implements IStoreService {
	
	@Autowired
	private IStoreJdbcRepository jdbcRepository;


	@Override
	public Page<ProductoDTO> getProductos(Pageable pageable) {
		List<ProductoDTO> productos =  jdbcRepository.getProductos(pageable);
		productos.forEach(p -> p.setImagenes(jdbcRepository.getImagenes(p.getId(), 1)));
		return new PageImpl<>(productos, pageable, productos.size());
	}

	@Override
	public ProductoDTO getProducto(long id) {
		ProductoDTO producto = jdbcRepository.getProducto(id);
		producto.setImagenes(jdbcRepository.getImagenes(producto.getId(), 0));
		return producto;
	}

}
