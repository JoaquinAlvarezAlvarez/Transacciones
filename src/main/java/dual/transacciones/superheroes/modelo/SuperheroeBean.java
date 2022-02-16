package dual.transacciones.superheroes.modelo;

import java.util.List;

public class SuperheroeBean {

	private long identificador;
	
	private String nombre;
	
	private String alterego;
	
	private String imagen;
	
	private List<SuperpoderBean> superpoderes;
	
	private List<DebilidadBean> debilidades;

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlterego() {
		return alterego;
	}

	public void setAlterego(String alterego) {
		this.alterego = alterego;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<SuperpoderBean> getSuperpoderes() {
		return superpoderes;
	}

	public void setSuperpoderes(List<SuperpoderBean> superpoderes) {
		this.superpoderes = superpoderes;
	}

	public List<DebilidadBean> getDebilidades() {
		return debilidades;
	}

	public void setDebilidades(List<DebilidadBean> debilidades) {
		this.debilidades = debilidades;
	}
	
}
