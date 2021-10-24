package unicodeTech.TestSuiteB;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.BasePackage.BaseInit;

public class NewProductLinks extends BaseInit{

	@BeforeTest
	public void setup() throws Exception {
		
		startUP();
	}
	
	
	@Test
	public void testNewProductLinks() {

		driver.get(storage.getProperty("url"));

		
		List<WebElement> newProducts = driver.findElements(By.xpath("//*[@class='contentContainer']/div[2]/table/tbody/tr/td/a[2]"));
	
		for(int count=0;count<newProducts.size();count++) {
			
			System.out.println(newProducts.get(count).getText());
		}
	
	}
}
