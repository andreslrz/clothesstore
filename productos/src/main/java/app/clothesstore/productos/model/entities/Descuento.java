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
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbDescuentos")
@AllArgsConstructor
@NoArgsConstructor
public class Descuento extends ModeloAuditoria {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8167892937434133333L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private long id;
	
	@Column(name = "descuento", nullable = false, updatable = true)
	private double descuento;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "inicio_vigencia", nullable = false)
	private LocalDateTime inicioVigencia;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "fin_vigencia", nullable = false)
	private LocalDateTime finVigencia;
	
	@Column(name = "idproducto", nullable = false)
	private long idProducto;

}

