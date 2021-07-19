package app.clothesstore.productos.admin.services.impl;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.clothesstore.productos.admin.repositories.IDescuentosRepository;
import app.clothesstore.productos.exceptions.ObjectAllreadyExistException;
import app.clothesstore.productos.model.entities.Descuento;

@Service
public class DescuentoService {
	
	private static final String YA_EXISTE_UN_DESCUENTO = "YA_EXISTE_UN_DESCUENTO";
	
	@Resource(name = "mensajes")
	private Properties mensajes;
	
	@Autowired
	private IDescuentosRepository descuentosRepository;
	
	public void crearDescuento(Descuento descuento) throws ObjectAllreadyExistException {
		if(!existe(descuento)) {
			descuentosRepository.saveAndFlush(descuento);
		} else {
			throw new ObjectAllreadyExistException(mensajes.getProperty(YA_EXISTE_UN_DESCUENTO));
		}
		
	}
	
	public boolean existe(Descuento descuento) {
		List<Descuento> descuentos = descuentosRepository.consultarVigenciasCruzadas(descuento.getIdProducto(), descuento.getInicioVigencia(), descuento.getFinVigencia());
		return !descuentos.isEmpty();
		
	}

}
