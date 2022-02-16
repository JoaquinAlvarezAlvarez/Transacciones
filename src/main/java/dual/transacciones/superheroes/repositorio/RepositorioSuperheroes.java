package dual.transacciones.superheroes.repositorio;

import java.util.List;

import dual.transacciones.superheroes.modelo.SuperheroeBean;

public interface RepositorioSuperheroes {

	List<SuperheroeBean> consultar();
	
	SuperheroeBean consultar(long identificador);
	
	void crear(SuperheroeBean superheroe);

	void modificar(SuperheroeBean superheroe);

	void eliminar(long identificador);

}
