package my.example.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SystemProperties {
	
	/**
	 * java -cp original-maven-java-project-0.0.1-SNAPSHOT.jar my.example.test.SystemProperties
	 * java -jar maven-java-project-0.0.1-SNAPSHOT.jar
	 */
	public static void main(String[] args) {
		SystemProperties a = new SystemProperties();
		log.info("Java Runtime Version : "+ a.getJavaVersion());
	}
 
	public String getJavaVersion(){
		log.trace("Entering getJavaVersion()");
		return System.getProperty("java.version");
	}
}
