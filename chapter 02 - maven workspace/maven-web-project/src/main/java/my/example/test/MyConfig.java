package my.example.test;

public class MyConfig {
	public String getJavaVersion() {
		SystemProperties s = new SystemProperties();
		return s.getJavaVersion();
	}
}
