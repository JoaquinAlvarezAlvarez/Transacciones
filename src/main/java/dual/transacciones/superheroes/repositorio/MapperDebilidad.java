package dual.transacciones.superheroes.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dual.transacciones.superheroes.modelo.DebilidadBean;

public class MapperDebilidad implements RowMapper<DebilidadBean> {

    @Override
    public DebilidadBean mapRow(ResultSet rs, int rowNum) throws SQLException {
    	DebilidadBean debilidad = new DebilidadBean();
    	debilidad.setIdentificador(rs.getLong("id"));
    	debilidad.setDebilidad(rs.getString("debilidad"));

        return debilidad;
    }

}
