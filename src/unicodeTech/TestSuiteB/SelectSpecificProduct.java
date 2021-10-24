package unicodeTech.TestSuiteB;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.BasePackage.BaseInit;

public class SelectSpecificProduct extends BaseInit{

	@BeforeTest
	public void setup() throws Exception {
		
		startUP();
	}
	
	@Test
	public void testSelectSpecificProduct() {

		driver.get(storage.getProperty("url"));
		
		WebElement manufacturer = isElementPresent("dd_manufacturer_name");
		List<WebElement> manuValues = manufacturer.findElements(By.tagName("option"));
	
		
		for(int count=1;count<manuValues.size();count++) {
			
			String manuText = manuValues.get(count).getText();
			
			if(manuText.equalsIgnoreCase("Lenovo")) {
				
				manuValues.get(count).click();
				logs.info(driver.getTitle());
				break;
			}
		}
		
		
	}
}
