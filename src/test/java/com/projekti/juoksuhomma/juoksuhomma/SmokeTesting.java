package com.projekti.juoksuhomma.juoksuhomma;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.projekti.juoksuhomma.juoksuhomma.web.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTesting {
	@Autowired
	private JuoksuController Bookcontroller;
	@Autowired
	private UserController Usercontroller;
	
	@Test
	public void contextLoads() throws Exception {
	assertThat(Bookcontroller).isNotNull();
	assertThat(Usercontroller).isNotNull();
	}
	}
