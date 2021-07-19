package app.clothesstore.productos.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tb_producto")
@AllArgsConstructor
@NoArgsConstructor
public class Producto extends ModeloAuditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)    
	private long id;
	
	@Column(name = "nombre", nullable = false, length = 200)
	private String nombre;
	
	@Column(name = "numero_vistas", nullable = false)
	private long numeroVistas;	
	
	@Column(name = "estado", nullable = false)
	private int estado; // 1 Activo - 2 Inactivo
	
	
	/*@OneToMany(mappedBy = "producto")
	private List<Precio> precios;*/
	
	/*@OneToMany(mappedBy = "producto")
	private List<Descuento> descuentos;*/
	

	
}
