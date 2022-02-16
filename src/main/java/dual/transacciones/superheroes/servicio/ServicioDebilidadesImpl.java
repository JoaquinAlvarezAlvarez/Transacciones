package dual.transacciones.superheroes.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dual.transacciones.superheroes.modelo.DebilidadBean;
import dual.transacciones.superheroes.repositorio.RepositorioDebilidades;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ServicioDebilidadesImpl implements ServicioDebilidades {

	@Autowired
	private RepositorioDebilidades repositorio;
	
	@Override
	public List<DebilidadBean> consultar(long identificadorHeroe) {
		return this.repositorio.consultar(identificadorHeroe);
	}

	@Override
	public void crear(long identificadorHeroe, List<DebilidadBean> debilidades) {
		this.repositorio.crear(identificadorHeroe, debilidades);
	}

	@Override
	public void eliminar(long identificadorHeroe) {
		this.repositorio.eliminar(identificadorHeroe);
	}

	
}
