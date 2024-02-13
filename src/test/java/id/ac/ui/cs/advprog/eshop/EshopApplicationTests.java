package id.ac.ui.cs.advprog.eshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true, "The context loads successfully");
	}

	@Test
	void testMain() {EshopApplication.main(new String[]{});}
	

}
