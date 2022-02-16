package dual.transacciones.superheroes.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import dual.transacciones.superheroes.modelo.SuperpoderBean;

public class MapperSuperpoder implements RowMapper<SuperpoderBean> {

    @Override
    public SuperpoderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
    	SuperpoderBean superpoder = new SuperpoderBean();
    	superpoder.setIdentificador(rs.getLong("id"));
    	superpoder.setPoder(rs.getString("poder"));

        return superpoder;
    }

}
