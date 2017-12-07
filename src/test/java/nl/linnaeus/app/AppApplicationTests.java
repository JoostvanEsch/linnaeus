package nl.linnaeus.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


import nl.linnaeus.app.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {
	
	public String passwordInMD5Encryption = "5f4dcc3b5aa765d61d8327deb882cf99";

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void md5Test() {
		assertEquals(passwordInMD5Encryption, User.encrypt("password"));
	}

}
