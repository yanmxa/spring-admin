package com.nood.hrm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HumanResousceApplicationTest {

	@Test
	public void contextLoads() {
		System.out.println(new SCryptPasswordEncoder().encode("123"));
	}


}
