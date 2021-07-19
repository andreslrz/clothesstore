package app.clothesstore.productos.admin.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.clothesstore.productos.model.entities.Precio;

@Repository
public interface IPreciosRepository extends JpaRepository<Precio, Long>{
	
	@Query("SELECT u FROM Precio u  WHERE u.idProducto = :idProducto")
	public Page<Precio> findAllByProducto(@Param("idProducto")long idProducto, Pageable pageable);
	
	@Query("SELECT u FROM Precio u  WHERE u.idProducto = :idProducto AND (:fecha1 BETWEEN u.inicioVigencia AND u.finVigencia OR :fecha2 BETWEEN u.inicioVigencia AND u.finVigencia)")
	public List<Precio> consultarVigenciasCruzadas(@Param("idProducto")long idProducto, @Param("fecha1") LocalDateTime fecha1, @Param("fecha2") LocalDateTime fecha2 );

}
