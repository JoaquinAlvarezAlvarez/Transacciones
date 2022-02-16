package dual.transacciones.superheroes.repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dual.transacciones.superheroes.modelo.DebilidadBean;

@Repository
public class RepositorioDebilidadesImpl implements RepositorioDebilidades {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<DebilidadBean> consultar(long identificadorHeroe) {
		try {
			return this.template.query("SELECT ID, DEBILIDAD "
					+ "FROM HEROE_DEBILIDAD HD "
					+ "INNER JOIN DEBILIDADES SP ON HD.IDDEBILIDAD=SP.ID  "
					+ "WHERE IDHEROE = ?",
					new MapperDebilidad(), identificadorHeroe);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void crear(long identificadorHeroe, List<DebilidadBean> debilidades) {
		try {
			
			debilidades.stream().forEach( debilidad -> {
				this.template.update("INSERT INTO HEROE_DEBILIDAD VALUES(?,?)", 
						identificadorHeroe, debilidad.getIdentificador());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void eliminar(long identificadorHeroe) {
		try {
			this.template.update("DELETE FROM HEROE_DEBILIDAD WHERE IDHEROE = ?", 
					identificadorHeroe);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
