package app.clothesstore.productos.store.repositories.impl;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import app.clothesstore.productos.model.dto.ImagenDTO;
import app.clothesstore.productos.model.dto.ProductoDTO;
import app.clothesstore.productos.store.repositories.IStoreJdbcRepository;
import app.clothesstore.productos.store.repositories.util.QueryBuilder;

@Repository
public class StoreJdbcRepository implements IStoreJdbcRepository{
	
	private static final String CONSULTA_PRODUCTOS_STORE = "CONSULTA_PRODUCTOS_STORE";
	private static final String CONDICION_PRODUCTO_ID = "CONDICION_PRODUCTO_ID";
	private static final String CONDICION_VIGENCIA_PRECIO = "CONDICION_VIGENCIA_PRECIO";
	private static final String ORDER_BY = "ORDER_BY";
	private static final String CONDICION_PRODUCTO_ESTADO_ACTIVO = "CONDICION_PRODUCTO_ESTADO_ACTIVO";
	private static final String CONSULTA_IMAGEN_STORE = "CONSULTA_IMAGEN_STORE";
	private static final String CONDICION_TIPO_IMAGEN = "CONSULTA_IMAGEN_STORE";
	private static final String CONDICION_IMAGENES_PRODUCTO = "CONDICION_IMAGENES_PRODUCTO";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name = "queries")
	private Properties queries;
	
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<ProductoDTO> getProductos(Pageable pageable) {
		var queryBuilder = new QueryBuilder();
		queryBuilder.setBaseQuery(queries.getProperty(CONSULTA_PRODUCTOS_STORE))
				.where(queries.getProperty(CONDICION_PRODUCTO_ESTADO_ACTIVO))
				.and(queries.getProperty(CONDICION_VIGENCIA_PRECIO))
				.orderBy(queries.getProperty(ORDER_BY))
				.limit()
				.offset();
		return  jdbcTemplate.query(queryBuilder.toString(), new Object[] {pageable.getPageSize(), pageable.getOffset()}, (rs, rowNum) -> new ProductoDTO(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getDouble("descuento"), rs.getDouble("precio_descuento"), null));
	}

	@SuppressWarnings("deprecation")
	@Override
	public ProductoDTO getProducto(long id) {
		var queryBuilder = new QueryBuilder();
		queryBuilder.setBaseQuery(queries.getProperty(CONSULTA_PRODUCTOS_STORE))
				.where(queries.getProperty(CONDICION_PRODUCTO_ID));
		return jdbcTemplate.queryForObject(queryBuilder.toString(), new Object[] {id},new BeanPropertyRowMapper<ProductoDTO>(ProductoDTO.class));
	}
	
	@SuppressWarnings("deprecation")
	public List<ImagenDTO> getImagenes(long idProducto, int tipoConsulta) {
		var queryBuilder = new QueryBuilder();
		queryBuilder.setBaseQuery(queries.getProperty(CONSULTA_IMAGEN_STORE))
					.where(queries.getProperty(CONDICION_IMAGENES_PRODUCTO));
		if(tipoConsulta == 1) {
			queryBuilder.and(queries.getProperty(CONDICION_TIPO_IMAGEN));
		}
		return jdbcTemplate.query(queryBuilder.toString(), new Object[] {idProducto}, (rs, rowNum) -> new ImagenDTO(rs.getString("base64"), rs.getInt("id_tipo_imagen")));
	}
	
}
