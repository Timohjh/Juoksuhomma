package com.projekti.juoksuhomma.juoksuhomma.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.projekti.juoksuhomma.juoksuhomma.domain.Juoksuhomma;


	public interface JuoksuhommaRepository extends CrudRepository<Juoksuhomma, Long>{

		List<Juoksuhomma> findByid(Long id);


}
