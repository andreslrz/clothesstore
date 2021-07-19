package app.clothesstore.productos.store.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import app.clothesstore.productos.model.dto.ImagenDTO;
import app.clothesstore.productos.model.dto.ProductoDTO;

public interface IStoreJdbcRepository {
	
	public List<ProductoDTO> getProductos(Pageable pageable);
	public ProductoDTO getProducto(long id);
	public List<ImagenDTO> getImagenes(long idProducto, int tipoConsulta);
	

}
