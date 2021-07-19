package app.clothesstore.productos.admin.services.impl;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.clothesstore.productos.admin.repositories.IProductoRepository;
import app.clothesstore.productos.admin.services.ICrudService;
import app.clothesstore.productos.exceptions.ObjectAllreadyExistException;
import app.clothesstore.productos.exceptions.ObjectNoFoundException;
import app.clothesstore.productos.model.entities.Producto;

@Service
public class ProductoService implements ICrudService<Producto, Long> {

	private static final String EL_PRODUCTO_YA_EXISTE = "EL_PRODUCTO_YA_EXISTE";
	private static final String EL_PRODUCTO_NO_EXISTE = "EL_PRODUCTO_NO_EXISTE";

	@Resource(name = "mensajes")
	private Properties mensajes;

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public Page<Producto> listar(Pageable pageable) {

		return null;
	}

	@Override
	public Producto buscarPorId(Long l) throws ObjectNoFoundException {
		Producto producto = null;
		try {
			Optional<Producto> optional = productoRepository.findById(l);
			if (optional.isPresent()) {
				producto = optional.get();
			}
			return producto;
		} catch (NoSuchElementException e) {
			throw new ObjectNoFoundException(mensajes.get(EL_PRODUCTO_NO_EXISTE).toString());
		}
	}

	@Override
	public void crear(Producto t) throws ObjectAllreadyExistException {
		if (!existe(t)) {
			productoRepository.saveAndFlush(t);
		} else {
			throw new ObjectAllreadyExistException(mensajes.getProperty(EL_PRODUCTO_YA_EXISTE));
		}
	}

	@Override
	public void actualizar(Producto t) throws ObjectNoFoundException {
		if (existe(t)) {
			productoRepository.saveAndFlush(t);
		} else {
			throw new ObjectNoFoundException(mensajes.getProperty(EL_PRODUCTO_NO_EXISTE));
		}
	}

	@Override
	public boolean existe(Producto t) {
		Producto resultado;
		try {
			if (t.getId() == 0) {
				resultado = productoRepository.buscarProductoPorNombre(t.getNombre());
			} else {
				resultado = buscarPorId(t.getId());
			}
		} catch (ObjectNoFoundException e) {
			resultado = null;
		} finally {
			
		}
		return resultado != null;
	}

}
