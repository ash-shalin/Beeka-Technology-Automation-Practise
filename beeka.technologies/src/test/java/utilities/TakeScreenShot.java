package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	WebDriver driver;

	public void printScreen(WebDriver driver, String fileName) {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File output = takeScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(output, new File("F:\\Beeka_Tech\\" + fileName));
			//give proper file path
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
