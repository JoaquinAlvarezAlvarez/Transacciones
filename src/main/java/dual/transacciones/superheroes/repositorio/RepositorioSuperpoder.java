package dual.transacciones.superheroes.repositorio;

import java.util.List;

import dual.transacciones.superheroes.modelo.SuperpoderBean;

public interface RepositorioSuperpoder {

	List<SuperpoderBean> consultar(long identificadorHeroe);
	
	void crear(long identificadorHeroe, List<SuperpoderBean> superpoderes);

	void eliminar(long identificadorHeroe);
}
