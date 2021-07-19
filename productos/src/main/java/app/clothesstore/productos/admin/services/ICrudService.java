package app.clothesstore.productos.admin.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import app.clothesstore.productos.exceptions.ObjectAllreadyExistException;
import app.clothesstore.productos.exceptions.ObjectNoFoundException;

public interface ICrudService<T, L> {
	
	public Page<T> listar(Pageable pageable);
	public T buscarPorId(L l) throws ObjectNoFoundException;
	public void crear(T t) throws ObjectAllreadyExistException;
	public void actualizar(T t) throws ObjectNoFoundException;
	public boolean existe(T t);

}
