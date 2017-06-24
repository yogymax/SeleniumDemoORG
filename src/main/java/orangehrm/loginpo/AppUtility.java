package orangehrm.loginpo;
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

import junit.framework.Assert;

public class AppUtility {
	
	
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
				Assert.fail("Specified driver is not configured...!");
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

}
