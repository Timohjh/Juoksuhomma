package com.projekti.juoksuhomma.juoksuhomma;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.projekti.juoksuhomma.juoksuhomma.domain.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class JPARepoTesting {
	@Autowired
	private JuoksuhommaRepository jrepository;
	@Autowired
	private CategoryRepository crepository;
	//@Autowired
	//private UserRepository urepository;
	@Test
    public void createNewJuoksuhommaAndCategory(){
        Category skeittaus = new Category("Test");
        crepository.save(skeittaus);
    
        Juoksuhomma juoksu = new Juoksuhomma("Matti", 15.0, 30, "12-07-16", "hyvä sää", skeittaus);
        jrepository.save(juoksu);

        assertThat(juoksu.getId()).isNotNull();
        assertThat(juoksu.getNimimerkki()).isEqualTo("Test");
    }
    
    @Test
    public void deleteANDFindJuoksuhomma(){
        Category rullaluistelu = new Category("Test");
        crepository.save(rullaluistelu);

        Juoksuhomma juoksu = new Juoksuhomma("Matti", 15.0, 30, "12-07-16", "hyvä sää", rullaluistelu);
        jrepository.save(juoksu);
        List<Juoksuhomma> juoksut = jrepository.findByid((long) 0);
        jrepository.delete(juoksut.get(0));


        assertThat(juoksu.getId()).isNotNull();

    }
}
