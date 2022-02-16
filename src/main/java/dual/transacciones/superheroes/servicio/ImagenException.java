package dual.transacciones.superheroes.servicio;

@SuppressWarnings("serial")
public class ImagenException extends RuntimeException{

	public ImagenException() {
	}

	public ImagenException(String mensajeError) {
		super(mensajeError);
	}
}
