package orangehrm.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;
	static String browserType;
	
	public static String getBrowserType() {
		return browserType;
	}

	public static void setBrowserType(String browser) {
		browserType = browser;
	}
	
	public Properties initProperties()  {
		FileReader file;
		try {
			file = new FileReader("./src//test//resources//config.properties");
			prop = new Properties();
			try {
				prop.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
