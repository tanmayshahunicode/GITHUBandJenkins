package unicodeTech.BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
1. Initialize and load properties file
2. Launch browser
3. Define Webdriver
4. Maximize browser window
5. Define timeunit
6. Initialize Logger
7. Object of ExcelFileReader class
8. Create isElementPresent method
*/

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import unicodeTech.Utility.ExcelFileReader;

public class BaseInit {

	public static WebDriver driver = null;
	public static Properties storage = null;
	public static ExcelFileReader data = null;
	public static Logger logs=null;
	
	public void startUP() throws Exception {
		
		if(driver==null) {
		
		logs = Logger.getLogger("devpinoyLogger");
			
		logs.info("Properties file is loading now..");
		storage = new Properties();
		FileInputStream fi = new FileInputStream("./src/unicodeTech/PropertiesData/ObjectStorage.properties");
		storage.load(fi);
		logs.info("Properties file loaded successfully..");
		logs.info("Browser will be launching soon");
		
		String browserKey = storage.getProperty("browser");
		
		if(browserKey.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "D:\\Software\\Testing-Tools\\Selenium\\WebDriver\\Drivers\\IEChromeFirefox\\FirefoxBrowser\\geckodriver.exe");
			driver = new FirefoxDriver();
			logs.info("Firefox browser launched");
		
		}else if(browserKey.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Software\\Testing-Tools\\Selenium\\WebDriver\\Drivers\\IEChromeFirefox\\ChromeBrowser\\new\\chromedriver.exe");
			driver = new ChromeDriver();
			logs.info("Firefox browser launched");

		}else {
			
			logs.info("No Browser defined");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		data = new ExcelFileReader("./src/unicodeTech/TestData/TestData.xlsx");

		
		}
	
	}
	
	public static WebElement isElementPresent(String propKey) {
		
		try {
			
			if(propKey.contains("xpath")) {
				
				return driver.findElement(By.xpath(storage.getProperty(propKey)));
			
			}else if(propKey.contains("id")) {
				
				return driver.findElement(By.id(storage.getProperty(propKey)));
			
			}else if(propKey.contains("name")) {
				
				return driver.findElement(By.name(storage.getProperty(propKey)));
			
			}else if(propKey.contains("linkText")) {
				
				return driver.findElement(By.linkText(storage.getProperty(propKey)));
			
			}else {
				
				System.out.println("key not found in the properties file");
			}
			
		}catch(Exception e) {
			
			
		}
		return null;
	}
	
	
	
}
