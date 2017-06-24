package orangehrm.loginpo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeDashboard implements PageObjectContract {

	@FindBy(xpath="/html/body/div[1]/div[3]/div/div[1]/h1")
	WebElement dashboardSubtitle;
	
	@FindBy(xpath="/html/body/div[1]/div[2]")
	WebElement dashboardMenus;
	
	
	public boolean isPageLoaded() {
		return dashboardSubtitle!=null && dashboardMenus!=null;
	}
}
