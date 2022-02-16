package dual.transacciones.superheroes.servicio;

import java.util.List;

import dual.transacciones.superheroes.modelo.SuperpoderBean;

public interface ServicioSuperpoder {

	List<SuperpoderBean> consultar(long identificadorHeroe);
	
	void crear(long identificadorHeroe, List<SuperpoderBean> debilidades);

	void eliminar(long identificadorHeroe);

}
