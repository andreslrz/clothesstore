package app.clothesstore.productos.model.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_precios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Precio extends ModeloAuditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8217441739756261692L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private long id;
	
	@Column(name = "precio", nullable = false)
	private double precio;

	@JsonFormat(pattern="yyy-MM-dd")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(name = "inicio_vigencia", nullable = false)
	private LocalDateTime inicioVigencia;
	
	@JsonFormat(pattern="yyy-MM-dd")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(name = "fin_vigencia", nullable = false)
	private LocalDateTime finVigencia;
	
	@Column(name = "id_producto", nullable = false)
	private long idProducto;
	

}
