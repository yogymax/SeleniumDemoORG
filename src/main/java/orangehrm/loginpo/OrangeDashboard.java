package orangehrm.loginpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scp.selenium.OrangeHRM.TestLoginFunctionlity;

public class OrangeDashboard implements PageObjectContract {

	static Logger logger = Logger.getLogger(OrangeDashboard.class);
	@FindBy(xpath="/html/body/div[1]/div[3]/div/div[1]/h1")
	WebElement dashboardSubtitle;
	
	@FindBy(xpath="/html/body/div[1]/div[2]")
	WebElement dashboardMenus;
	
	
	public boolean isPageLoaded() {
		logger.info("isPageLoaded method of dashboard page");
		return dashboardSubtitle!=null && dashboardMenus!=null;
	}
}
