package unicodeTech.TestSuiteA;

/*
1. Create a method with the @DataProvider annotation
2. Store all your test data in the form of two dimensional object array
3. Return two dimensional object array
4. Define dataProvidr="method name" with @Test
5. Number of arguments in the method should be equal to number of columns coming from @DataProvider
6. Use argument variable in the script
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import unicodeTech.BasePackage.BaseInit;
import unicodeTech.Utility.ExcelFileReader;
import unicodeTech.Utility.MyLibrary;

public class ValidateUser extends BaseInit {

	@BeforeTest
	public void setup() throws Exception {

		startUP();
	}

	@Test(dataProvider = "getTestData")
	public void testValidateUser(String email, String pwd) {

		driver.get(storage.getProperty("url"));
		MyLibrary.signIN(email, pwd);

		boolean output;

		try {

			output = driver.findElement(By.linkText("Log Off")).isDisplayed();

		} catch (Exception e) {

			output = false;
		}

		if (output) {

			MyLibrary.getScreenShot(email, driver);
			System.out.println("User is logged in successfully");
			MyLibrary.signOUT();

		} else {

			MyLibrary.getScreenShot(email, driver);
			System.out.println("Invalid username or password");
			Assert.fail("Invalid username or password");
		}

	}

	@DataProvider
	public Object[][] getTestData() {
		
		return MyLibrary.getTestDataFromXLS(data, "ValidateUser");
		
		
	}
	
	
	
	/*
	@DataProvider
	public Object[][] getTestData() {

		Object[][] data = new Object[3][2]; // [1stBox]- Number of iterations(Set of test data) [2ndBox]- Number of
											// fields

		data[0][0] = "demo@unicodetechnologies.in";
		data[0][1] = "unicode";

		data[1][0] = "demo1@unicodetechnologies.in";
		data[1][1] = "unicode1";

		data[2][0] = "demo2@unicodetechnologies.in";
		data[2][1] = "unicode2";

		return data;

	}
	*/
}
