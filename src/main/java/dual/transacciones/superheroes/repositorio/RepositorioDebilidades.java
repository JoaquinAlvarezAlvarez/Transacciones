package dual.transacciones.superheroes.repositorio;

import java.util.List;

import dual.transacciones.superheroes.modelo.DebilidadBean;

public interface RepositorioDebilidades {

	List<DebilidadBean> consultar(long identificadorHeroe);
	
	void crear(long identificadorHeroe, List<DebilidadBean> superpoderes);

	void eliminar(long identificadorHeroe);
}
