package Jaswanth.Automation.Script;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Jaswanth.Automation.Object.SampleTestObjects;
import Jaswanth.Automation.Utilities.ExtentTestManager;
import Jaswanth.Automation.Utilities.Login;
import Jaswanth.Automation.Utilities.Page;

public class SampleTest extends Login
{
	@Test(dataProvider="readExcelData")
	public static void test(String Browser)
	{
		try
		{
			System.out.println("Dracarys............................."+Browser);
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			Thread.sleep(6000);
			Page.enterValueWhenAvailable(SampleTestObjects.GoogleInput_XPATH, "Jaswanth", 2000, 3);
			Page.clickWhenAvailable(SampleTestObjects.GoogleInput_XPATH,2000, 3);
			Thread.sleep(6000);
			
			ExtentTestManager.startTest(Login.fileLocation, "Google Chrome Opened");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Google Text Entered",ExtentTestManager.getTest().addBase64ScreenShot("data:image/png;base64,"+((TakesScreenshot) driver).
					getScreenshotAs(OutputType.BASE64)));
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
