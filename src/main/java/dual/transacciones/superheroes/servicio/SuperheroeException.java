package dual.transacciones.superheroes.servicio;

@SuppressWarnings("serial")
public class SuperheroeException extends Exception{

	public SuperheroeException() {
	}

	public SuperheroeException(String mensajeError) {
		super(mensajeError);
	}
}
