package unicodeTech.TestSuiteB;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import unicodeTech.BasePackage.BaseInit;
import unicodeTech.Utility.ExcelFileReader;
import unicodeTech.Utility.MyLibrary;

public class SearchProduct extends BaseInit{

	@BeforeTest
	public void setup() throws Exception {
		
		startUP();
	}
	
	
	@Test(dataProvider="getTestData")
	public void testSearchProduct(String keyword) {
		
		driver.get(storage.getProperty("url"));

		driver.findElement(By.name("keywords")).sendKeys(keyword);
		driver.findElement(By.name("keywords")).sendKeys(Keys.ENTER);
		
		
		
	}
	
	@DataProvider
	public Object[][] getTestData() {
		
		return MyLibrary.getTestDataFromXLS(data, "SearchProduct");
		
	}
	}

