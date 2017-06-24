package orangehrm.loginpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrangeHRMLogin implements PageObjectContract{

	static Logger logger = Logger.getLogger(OrangeHRMLogin.class);
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/img")
	WebElement orgHeading;
	
	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement submitBtn;
	
	@FindBy(id="spanMessage")
	WebElement invalidLoginError;

	
	@FindBy(id="divUsername")
	WebElement usernameDiv;
	
	@FindBy(id="divPassword")
	WebElement passwordDiv;
	
	
	public String checkInvalidCredentials(String uname,String pwd){
		logger.info("checkInvalidCredentials method " +uname  +" Passowrd " +pwd);
		enterUserName(uname);
		enterPassWord(pwd);
		clickOnSubmit();
		return getErrorMessage();
	}
	
	public OrangeDashboard enterCredentials(String uname,String pwd){
		logger.info("enterCredentials method " +uname  +" Passowrd " +pwd);
		enterUserName(uname);
		enterPassWord(pwd);
		clickOnSubmit();
		
	/*	if(invalidLoginError!=null)
			return null;*/
		
		return PageFactory.initElements(AppUtility.driver, OrangeDashboard.class);
	}

	private void clickOnSubmit() {
		logger.info("clickOnSubmit method ");
		this.submitBtn.click();
	}

	private void enterPassWord(String pwd) {
		logger.info(" enterPassWord " +pwd);
		this.password.clear();
		this.password.sendKeys(pwd);
	}

	private void enterUserName(String uname) {
		logger.info(" enterUserName " +uname);
		this.userName.clear();
		this.userName.sendKeys(uname);
	}
	
	
	public void validateLoginPage(){
		logger.info(" validateLoginPage ");
		Assert.assertEquals(usernameDiv.getText(), "Username");
		Assert.assertEquals(passwordDiv.getText(), "Password");
		Assert.assertNotNull(orgHeading);
		Assert.assertEquals(submitBtn.getAttribute("value"), "LOGIN");
		Assert.assertNull(invalidLoginError);
	}
	
	private String getErrorMessage(){
		logger.info(" getErrorMessage ");
		if(null==invalidLoginError)
			return null;
		else
			return invalidLoginError.getText();
	}

	public boolean isPageLoaded() {
		return orgHeading!=null && submitBtn!=null;
	}
	
}
