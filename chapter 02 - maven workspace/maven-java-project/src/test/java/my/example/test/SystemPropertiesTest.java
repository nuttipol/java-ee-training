package my.example.test;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.test.SystemProperties;

@Slf4j
public class SystemPropertiesTest {

	@Test
	public void testJavaVersion() {
		SystemProperties a = new SystemProperties(); 
		log.info("Java Runtime Version : "+ a.getJavaVersion());
	}

}
