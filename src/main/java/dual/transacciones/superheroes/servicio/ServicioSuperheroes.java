package dual.transacciones.superheroes.servicio;

import java.util.List;

import dual.transacciones.superheroes.modelo.SuperheroeBean;

public interface ServicioSuperheroes {

	List<SuperheroeBean> consultar();
	
	SuperheroeBean consultar(long identificador) throws SuperheroeException;
	
	void crear(SuperheroeBean superheroe) throws SuperheroeException;

	void modificar(SuperheroeBean superheroe) throws SuperheroeException;

	void eliminar(long identificador) throws SuperheroeException;

}
