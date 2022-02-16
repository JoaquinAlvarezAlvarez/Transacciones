package dual.transacciones.superheroes.repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dual.transacciones.superheroes.modelo.SuperpoderBean;

@Repository
public class RepositorioSuperpoderImpl implements RepositorioSuperpoder{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<SuperpoderBean> consultar(long identificadorHeroe) {
		try {
			return this.template.query("SELECT ID, PODER "
					+ "FROM HEROE_PODER HP "
					+ "INNER JOIN SUPERPODERES SP ON HP.IDPODER=SP.ID  "
					+ "WHERE IDHEROE = ?",
					new MapperSuperpoder(), identificadorHeroe);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void crear(long identificadorHeroe, List<SuperpoderBean> superpoderes) {
		try {
			
			superpoderes.stream().forEach( superpoder -> {
				this.template.update("INSERT INTO HEROE_PODER VALUES(?,?)", 
						identificadorHeroe, superpoder.getIdentificador());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void eliminar(long identificadorHeroe) {
		try {
			this.template.update("DELETE FROM HEROE_PODER WHERE IDHEROE = ?", 
					identificadorHeroe);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
