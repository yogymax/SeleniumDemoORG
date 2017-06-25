package orangehrm.loginpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.scp.selenium.OrangeHRM.TestLoginFunctionlity;

public class OrangeDashboard implements PageObjectContract {

	static Logger logger = Logger.getLogger(OrangeDashboard.class);
	@FindBy(xpath="/html/body/div[1]/div[3]/div/div[1]/h1")
	WebElement dashboardSubtitle;
	
	@FindBy(xpath="/html/body/div[1]/div[2]")
	WebElement dashboardMenus;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/ul/li[2]/a/b")
	WebElement pim;
	
	@FindBy(id="menu_pim_Configuration")
	WebElement configuration;
	
	
	public boolean isPageLoaded() {
		logger.info("isPageLoaded method of dashboard page");
		return dashboardSubtitle!=null && dashboardMenus!=null;
	}
	
	
	public void clickOnPIMAddEmployee(){
		WebDriver driver = AppUtility.driver;
		Actions action = new Actions(driver);
		action.moveToElement(pim).moveToElement(configuration).build();
		
		driver.findElement(By.id("menu_pim_viewReportingMethods")).click();;
		
		
	}
	
	
}
