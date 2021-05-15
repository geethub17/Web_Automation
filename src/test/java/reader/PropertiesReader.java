package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader {
	
	private BufferedReader bufferedReader;
	private Properties properties; 
	
	public  PropertiesReader() {
		try {
			bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "//data//Options.properties"));
			properties = new Properties();
			properties.load(bufferedReader);
			bufferedReader.close();
		} catch (Exception e) {
			throw new RuntimeException("Error occured at reading properties file: "+e);
		}
	}
	
	public String getRunType() {
		String runType = properties.getProperty("runType");
		if( runType != null )
			return runType;
		else
			throw new RuntimeException("Run type is not specified in properties file ");
	}
	
	public String getBrowserType() {
		String browserType = properties.getProperty("browser");
		if( browserType != null )
			return browserType;
		else
			throw new RuntimeException("Browser type is not specified in properties file ");
	}
	
	public String getIp() {
		String ip = properties.getProperty("ip");
		if( ip != null )
			return ip;
		else
			throw new RuntimeException("IP address is not specified in properties file ");
	}
	
	public String getUserName() {
		String userName = properties.getProperty("userName");
		if( userName != null )
			return userName;
		else
			throw new RuntimeException("User name is not specified in properties file ");
	}
	
	public String getPassword() {
		String password = properties.getProperty("password");
		if( password != null )
			return password;
		else
			throw new RuntimeException("Password is not specified in properties file ");
	}
	
	public int getExplicitWait() {
		String explicitWait = properties.getProperty("explicitWait");
		if( explicitWait != null )
			return Integer.parseInt(explicitWait);
		else
			throw new RuntimeException("Explicit wait time is not specified in properties file ");
	}
	
	public String getURL() {
		String url = properties.getProperty("url");
		if( url != null )
			return url;
		else
			throw new RuntimeException("URL is not specified in properties file ");
	}

}
