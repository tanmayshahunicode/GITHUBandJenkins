package unicodeTech.TestSuiteA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.BasePackage.BaseInit;
import unicodeTech.Utility.MyLibrary;

public class BestsellerLinks extends BaseInit{

	@BeforeTest
	public void setup() throws Exception {
		
		startUP();
	}
	
	@Test
	public void testBestsellerLinks() {
		
		driver.get(storage.getProperty("url"));
		
		WebElement bestseller = driver.findElement(By.xpath("//*[@id=\"right_sidebar\"]/div[2]/div[2]"));
		List<WebElement> bestsellerLinks = bestseller.findElements(By.tagName("a"));
	
		for(int count=0;count<bestsellerLinks.size();count++) {
			
			String prodText = bestsellerLinks.get(count).getText();
			bestsellerLinks.get(count).click();
			System.out.println(driver.getTitle()+"-->"+driver.getCurrentUrl());
			
			MyLibrary.getScreenShot(prodText, driver);
			
			driver.navigate().back();
			
			bestseller = driver.findElement(By.xpath("//*[@id=\"right_sidebar\"]/div[2]/div[2]"));
			bestsellerLinks = bestseller.findElements(By.tagName("a"));
		
		
		}
	
	
	
	
	}
}
