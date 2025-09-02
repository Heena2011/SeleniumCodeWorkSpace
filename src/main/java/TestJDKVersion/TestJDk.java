package TestJDKVersion;

public class TestJDk {

	public static void main(String[] args) {
		
		String JavaVersion = System.getProperty("java.version");
		String javaRuntimeVersion = System.getProperty("java.runtime.version");
		
		System.out.println("Java Version"+JavaVersion);
		System.out.println("Java RUntime version" + javaRuntimeVersion);
	}
}
