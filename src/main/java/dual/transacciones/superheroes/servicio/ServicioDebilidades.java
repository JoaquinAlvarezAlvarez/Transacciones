package dual.transacciones.superheroes.servicio;

import java.util.List;

import dual.transacciones.superheroes.modelo.DebilidadBean;

public interface ServicioDebilidades {

	List<DebilidadBean> consultar(long identificadorHeroe);
	
	void crear(long identificadorHeroe, List<DebilidadBean> superpoderes);

	void eliminar(long identificadorHeroe);

}
