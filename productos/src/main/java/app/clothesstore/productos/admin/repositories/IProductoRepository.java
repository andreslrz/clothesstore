package app.clothesstore.productos.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.clothesstore.productos.model.entities.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
	
	@Query("SELECT u FROM Producto u WHERE u.nombre = :nombre")
	public Producto buscarProductoPorNombre(@Param("nombre") String nombre);

}
