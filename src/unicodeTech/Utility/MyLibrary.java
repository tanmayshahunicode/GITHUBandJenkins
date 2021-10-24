package unicodeTech.Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import unicodeTech.BasePackage.BaseInit;

public class MyLibrary extends BaseInit {

	public static void signIN(String email, String pwd) {

		// driver.findElement(By.linkText(storage.getProperty("lnk_logurselfin_linkText"))).click();
		isElementPresent("lnk_logurselfin_linkText").click();
		isElementPresent("ip_emailAddress_name").sendKeys(email);
		isElementPresent("ip_password_name").sendKeys(pwd);
		isElementPresent("btn_signin_id").click();

	}

	public static void signOUT() {

		isElementPresent("lnk_logoff_linkText").click();
		isElementPresent("btn_continue_id").click();

	}

	public static String getScreenShot(String imageName, WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File scrFile = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\src\\unicodeTech\\Screenshots\\" + imageName
				+ System.currentTimeMillis() + ".png";

		// System.out.println(path);
		File destination = new File(path);

		try {

			FileHandler.copy(scrFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}

	public static Object[][] getTestDataFromXLS(ExcelFileReader data, String testName) {


		int rows = data.totalRow(testName);
		int cols = data.totalColumn(testName);

		Object[][] myData = new Object[rows - 1][cols];

		for (int row = 1; row < rows; row++) {

			for (int col = 0; col < cols; col++) {

				myData[row - 1][col] = data.getData(testName, row, col);
			}
		}
		
		return myData;

	}

}
