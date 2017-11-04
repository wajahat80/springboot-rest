package net.rwa.springboot.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import net.rwa.springboot.config.JPAConfig;

@RunWith(SpringRunner.class)
@SpringBootTest

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAConfig.class })
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
//		DbUnitTestExecutionListener.class })
@PropertySource("classpath:application.properties")

public class SpringbootRestApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("..............................Testing ...........................");
	}

}
