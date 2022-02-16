package dual.transacciones.superheroes.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dual.transacciones.superheroes.modelo.SuperpoderBean;
import dual.transacciones.superheroes.repositorio.RepositorioSuperpoder;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ServicioSuperpoderImpl implements ServicioSuperpoder {

	@Autowired
	private RepositorioSuperpoder repositorio;
	
	@Override
	public List<SuperpoderBean> consultar(long identificadorHeroe) {
		return this.repositorio.consultar(identificadorHeroe);
	}

	@Override
	public void crear(long identificadorHeroe, List<SuperpoderBean> superpoderes) {
		this.repositorio.crear(identificadorHeroe, superpoderes);
	}

	@Override
	public void eliminar(long identificadorHeroe) {
		this.repositorio.eliminar(identificadorHeroe);
	}

	
}
