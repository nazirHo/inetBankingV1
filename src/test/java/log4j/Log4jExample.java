package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4jExample {
	public static void main(String[] args) {
		Logger logger=Logger.getLogger("Log4jExample");
	//DOMConfigurator.configure("log4j.xml");
	PropertyConfigurator.configure("Log4j.properties");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\ISMA\\eclipse-workspace\\inetBankingV1\\Drivers\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	logger.info("yes i am");
	driver.get("http://newtours.demoaut.com/");
	driver.close();
	
	}
	
}



