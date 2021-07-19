package app.clothesstore.productos.admin.services.impl;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.clothesstore.productos.admin.repositories.IPreciosRepository;
import app.clothesstore.productos.exceptions.ObjectAllreadyExistException;
import app.clothesstore.productos.model.entities.Precio;

@Service
public class PrecioService {
	
	private static final String YA_EXISTE_UN_PRECIO = "YA_EXISTE_UN_PRECIO";
	
	@Resource(name = "mesnajes")
	private Properties mensajes;
	
	@Autowired
	private IPreciosRepository preciosRepository;

	public Page<Precio> listar(long idProducto,Pageable pageable) {
		return preciosRepository.findAllByProducto(idProducto, pageable);
	}

	public Precio buscarPorId(Long l) {
		return preciosRepository.getById(l);
	}

	public void crear(Precio t) throws ObjectAllreadyExistException {
		if(!existe(t)) {
			preciosRepository.saveAndFlush(t);
		} else {
			throw new ObjectAllreadyExistException(mensajes.getProperty(YA_EXISTE_UN_PRECIO));
		}
		
	}

	public void actualizar(Precio t) {
		preciosRepository.saveAndFlush(t);		
	}

	public boolean existe(Precio t) {
		List<Precio> precio = preciosRepository.consultarVigenciasCruzadas(t.getIdProducto(), t.getInicioVigencia(), t.getFinVigencia());
		return !precio.isEmpty();
	}

}
