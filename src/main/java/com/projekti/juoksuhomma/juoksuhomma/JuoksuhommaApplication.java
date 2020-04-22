package com.projekti.juoksuhomma.juoksuhomma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.projekti.juoksuhomma.juoksuhomma.domain.*;

@SpringBootApplication
public class JuoksuhommaApplication  /*extends SpringBootServletInitializer */{
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder
	application) {
	return application.sources(JuoksuhommaApplication.class);
	} */
	private static final Logger log = LoggerFactory.getLogger(JuoksuhommaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(JuoksuhommaApplication.class, args);
	}
	@Bean
	public CommandLineRunner juoksuhommaDemo(JuoksuhommaRepository jrepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			// demo dataa
			log.info("Tallenetaan lenkkeja");
			crepository.save(new Category("Juokseminen"));
			crepository.save(new Category("Hölkkääminen"));
			crepository.save(new Category("Kävely"));
			crepository.save(new Category("Pyöräily"));
			
			jrepository.save(new Juoksuhomma("Kalle", 12.0, 12, "20-07-13", "hyvä sää", crepository.findByName("Juokseminen").get(0)));	
			jrepository.save(new Juoksuhomma("Pera", 15.0, 60, "07-01-09", "uusi ennätys", crepository.findByName("Hölkkääminen").get(0)));
			jrepository.save(new Juoksuhomma("Tiina", 2.0, 19, "09-09-14", "", crepository.findByName("Juokseminen").get(0)));
			jrepository.save(new Juoksuhomma("Pera", 9.0, 30, "12-09-19", "nilkka nyrjähti", crepository.findByName("Pyöräily").get(0)));
			jrepository.save(new Juoksuhomma("Peppi", 10.0, 70, "09-06-20", "hieno ilma", crepository.findByName("Kävely").get(0)));
			
			User user1 = new User("admin", "$2a$10$Xv.JoU3miO5nrNI.vDveBOMk/ClhbvcM6fCF51d2seUDJta2QpewK", "ADMIN"); 
			User user2 = new User("user", "$2a$10$d3Lv3grbBVXT3vJI8F.88epPrqIxQ4ioomv3DIAExHyhfMQ550t.6", "USER");
			User user3 = new User("Pera", "$2a$10$NblaUAoeKp/fEEFX68TA4unxYzTaO5dtBOF1Xe8y4LcLxn6xb481e", "USER");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("kaikki lenkit");
			for (Juoksuhomma juoksuhomma : jrepository.findAll()) {
				log.info(juoksuhomma.toString());
			}

		};
	}
	
}
