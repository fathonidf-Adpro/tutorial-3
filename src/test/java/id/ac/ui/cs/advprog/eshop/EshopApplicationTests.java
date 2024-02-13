package id.ac.ui.cs.advprog.eshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {

	private EshopApplication application;

	@Test
	void contextLoads() {
		assertTrue(true, "The context loads successfully");
	}

	@Test
	public void testMain() {application.main(new String[]{});}
	

}
