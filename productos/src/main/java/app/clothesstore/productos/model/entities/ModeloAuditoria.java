package app.clothesstore.productos.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class ModeloAuditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4770516944011683146L;
	
	@Column(name = "usuario_creacion", nullable = false, length = 20, updatable = false)
	private String usuarioCreacion;
	
	@Column(name = "usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime fechaCreacion;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@Column(name = "fecha_modificacion", nullable = false)
	private LocalDateTime fechaModificacion;

}
