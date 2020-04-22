package com.projekti.juoksuhomma.juoksuhomma.domain;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NimiRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<Juoksuhomma> findAllNimet() {
		return jdbcTemplate.query("select * from juoksuhomma, user where juoksuhomma.nimimerkki=user.username", new JuoksuRowMapper());
	}
}

