package dual.transacciones.superheroes.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dual.transacciones.superheroes.modelo.SuperheroeBean;

public class MapperSuperheroe implements RowMapper<SuperheroeBean> {

    @Override
    public SuperheroeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
    	SuperheroeBean superheroe = new SuperheroeBean();
    	superheroe.setIdentificador(rs.getLong("id"));
        superheroe.setNombre(rs.getString("nombre"));
        superheroe.setAlterego(rs.getString("alterego"));
        superheroe.setImagen(rs.getString("img"));

        return superheroe;
    }

}
