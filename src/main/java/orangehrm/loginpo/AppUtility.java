package orangehrm.loginpo;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import com.scp.selenium.OrangeHRM.AppConstants;
import com.scp.selenium.OrangeHRM.AppConstants.MyBrowsers;

public class AppUtility {
	
	/**
	 * 
	 * 
	 * http://Admin:admin@opensource.demo.orangehrmlive.com/index.php
	 */

	
	/**
	 * 
	 * Webelements
	 * 1. Input Text
	 * 2. Radio Buttons
	 * 3. CheckBox
	 * 4. Links
	 * 5. Dropdown
	 * 6. Multichoice Dropdown
	 * 7. Buttons
	 * 8. Alerts
	 * 9. Scroll
	 * 10. File Upload - AutoV3 and Robot Classes
	 * 11. Handling Windows
	 * 12. Handling Frames
	 * 13. Date Picker
	 * 14. Mouse Hovor
	 * 15. Navigations - Frwd, backword, to another page,refresh
	 * 16. Refresh
	 * 17. Maximize/Minimize Window
	 * 19. Launch Broswer
	 * 20. Screenshots
	 * 21. Security Certificates
	 * 22. Authetication Popups  > http://Admin:admin@opensource.demo.orangehrmlive.com/index.php
	 * 23. DatePicker
	 * 24. Different kinds of wait
	 * 25. Autopapulate
	 * 26. ToolTip
	 * 27. Handling Dynamic tables
	 * 28. Checking Focus on a elements
	 * 29. Checking the css properties
	 * 30. Image comparism - Sikuli
	 * 31. Database Testing
	 * 32. API Testing
	 * 
	 * 
	 * 
	 * Alerts in Selenium
	 * 1. Simple  - Ok or close icon
	 * 2. Prompt  > Input text, OK button or close icon
	 * 3. Confirmation  >  Ok and cancel
	 * 	 * Methods > 
	 * 		driver.switchTo.alert().getText() > To get the text
	 * 		driver.switchTo.alert().dismiss() > To close the alert
	 * 		driver.switchTo.alert().accept()  > All types of alert
	 * 		driver.switchTo.alert().sendKeys("abcd")  .... This wil be for promt alert
	 * 
	 * Scroll
	 * 			JavascriptExecutor jse = (JavascriptExecutor)driver;
	 * 			jse.executeScript("window.scrollBy(0,250)", "")
	 * 
	 * 
	 * 
	 * File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);
	 * FileUtils. copyFile(src, new File("C:/selenium/error.png"));
	 */
	
	static WebDriver driver =null;
	static Logger logger = Logger.getLogger(AppUtility.class);
	
	public static WebDriver initilizeWebDriver(MyBrowsers type){
		logger.info("Inside initilizeWebDriver method");
		logger.warn("Inside initilizeWebDriver method type " +type);
		switch(type){
			case FIREFOX:	
				driver = new FirefoxDriver();
				break;
			case CHROME:
				File f = new File("");
				String driverpath = f.getAbsolutePath()+"\\src\\main\\java\\chromedriver.exe";
				System.out.println(driverpath);
				System.setProperty("webdriver.chrome.driver", driverpath);
				driver = new ChromeDriver();
				break;
			case INTERNETEXPLORER:
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progvaltion_11\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
				driver = new InternetExplorerDriver();
				break;
			case SAFARI:
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progvaltion_11\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
				driver = new SafariDriver();
				break;
			default:
				System.out.println("Specified driver is not configured...!");
		}
		
		return driver;
	}
	
	public static OrangeHRMLogin enterApplicationUrl(MyBrowsers type){
		WebDriver driver = initilizeWebDriver(type);
		driver.get(AppConstants.APPLICATION_URL);
		driver.manage().window().maximize();
		return PageFactory.initElements(driver, OrangeHRMLogin.class);
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	
	public static void setDataToClipBoard(String path) {
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);	
	}
	
	
}
