package dual.transacciones.superheroes.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dual.transacciones.superheroes.modelo.DebilidadBean;
import dual.transacciones.superheroes.modelo.SuperheroeBean;
import dual.transacciones.superheroes.modelo.SuperpoderBean;
import dual.transacciones.superheroes.repositorio.RepositorioSuperheroes;

@Service
@Transactional(rollbackFor = SuperheroeException.class, noRollbackFor = ImagenException.class)
public class ServicioSuperheroesImpl implements ServicioSuperheroes{

	@Autowired
	private RepositorioSuperheroes repositorio;
	
	@Autowired
	private ServicioSuperpoder servicioSuperpoder;

	@Autowired
	private ServicioDebilidades servicioDebilidades;
	
	public List<SuperheroeBean> consultar(){
		List<SuperheroeBean> superheroes = this.repositorio.consultar();
		if(superheroes.isEmpty()) {
			return superheroes;
		}
		
		superheroes.stream().forEach(superheroe -> {
			superheroe.setSuperpoderes(this.consutarSuperpoderes(superheroe.getIdentificador()));
			superheroe.setDebilidades(this.consutarDebilidades(superheroe.getIdentificador()));
		});

		return superheroes;
	}

	@Override
	public SuperheroeBean consultar(long identificador) throws SuperheroeException {
		try {
			SuperheroeBean superheroe = this.repositorio.consultar(identificador);
			superheroe.setSuperpoderes(this.consutarSuperpoderes(identificador));
			superheroe.setDebilidades(this.consutarDebilidades(identificador));

			return superheroe;
			
		} catch (EmptyResultDataAccessException e) {
			throw new SuperheroeException("No se ha encontrado el superhéroe "
					+ "con identificador " + identificador);
		}
	}
	
	private List<SuperpoderBean> consutarSuperpoderes(long identificador){
		return this.servicioSuperpoder.consultar(identificador);
	}

	private List<DebilidadBean> consutarDebilidades(long identificador){
		return this.servicioDebilidades.consultar(identificador);
	}

	@Override
	public void crear(SuperheroeBean superheroe) throws SuperheroeException {
		try {
			SuperheroeBean superheroeExiste = this.repositorio.
					consultar(superheroe.getIdentificador());
			if(superheroeExiste != null) {
				throw new SuperheroeException("Ya existe un superhéroe con "
						+ "el identificador " + superheroe.getIdentificador());
			}
		} catch (EmptyResultDataAccessException e) {;}
		
		this.repositorio.crear(superheroe);
		this.crearSuperpoderes(superheroe);
		this.crearDebilidades(superheroe);

		if(superheroe.getImagen() == null || superheroe.getImagen().length() == 0){
			throw new ImagenException();
		}
	}

	@Override
	public void modificar(SuperheroeBean superheroe) throws SuperheroeException {
		try {
			this.repositorio.consultar(superheroe.getIdentificador());
			this.repositorio.modificar(superheroe);
			this.servicioSuperpoder.eliminar(superheroe.getIdentificador());
			this.crearSuperpoderes(superheroe);
			this.servicioDebilidades.eliminar(superheroe.getIdentificador());
			this.crearDebilidades(superheroe);
			
			if(superheroe.getImagen() == null || superheroe.getImagen().length() == 0){
				throw new ImagenException();
			}

		} catch (EmptyResultDataAccessException e) {
			throw new SuperheroeException("El superhéroe con identificador " 
						+ superheroe.getIdentificador() + " no existe.");
		}
	}
	
	private void crearSuperpoderes(SuperheroeBean superheroe) throws SuperheroeException {
		if(superheroe.getSuperpoderes() == null 
				||  superheroe.getSuperpoderes().isEmpty()) {
			throw new SuperheroeException("El superhéroe necesita al menos un superpoder");
		}
		
		this.servicioSuperpoder.crear(superheroe.getIdentificador(), 
				superheroe.getSuperpoderes());
	}

	private void crearDebilidades(SuperheroeBean superheroe) throws SuperheroeException {
		if(superheroe.getDebilidades() == null 
				||  superheroe.getDebilidades().isEmpty()) {
			throw new SuperheroeException("El superhéroe necesita al menos una debilidad");
		}

		this.servicioDebilidades.crear(superheroe.getIdentificador(), 
				superheroe.getDebilidades());
	}

	@Override
	public void eliminar(long identificador) throws SuperheroeException {
		try {
			this.repositorio.consultar(identificador);
			this.servicioSuperpoder.eliminar(identificador);
			this.servicioDebilidades.eliminar(identificador);
			this.repositorio.eliminar(identificador);
		} catch (EmptyResultDataAccessException e) {
			throw new SuperheroeException("El superhéroe con identificador " 
					+ identificador + " no existe.");
		}
	}
}
