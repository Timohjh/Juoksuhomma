package com.projekti.juoksuhomma.juoksuhomma.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class JuoksuRowMapper implements RowMapper<Juoksuhomma> {
	public Juoksuhomma mapRow(ResultSet rs, int rowNum) throws SQLException {
		Juoksuhomma omatjuoksut = new Juoksuhomma();
		omatjuoksut.setId(rs.getLong("id"));
		omatjuoksut.setNimimerkki(rs.getString("nimimerkki"));
		omatjuoksut.setMatka(rs.getDouble("matka"));
		omatjuoksut.setKesto(rs.getInt("kesto"));
		omatjuoksut.setPvm(rs.getString("pvm"));
		omatjuoksut.setLisatieto(rs.getString("lisatieto"));
		omatjuoksut.setCategory(rs.getString("category_id"));
		return omatjuoksut;
	}
}