package com.projekti.juoksuhomma.juoksuhomma.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.projekti.juoksuhomma.juoksuhomma.domain.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findByName(String name);
	List<Category> findAll();
}