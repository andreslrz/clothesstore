package app.clothesstore.productos.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
	
	private long id;
	private String nombre;
	private double precio;
	private double descuento;
	private double precioDecuento;
	private List<ImagenDTO> imagenes;
	

}
