package orangehrm.loginpo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrangeHRMLogin implements PageObjectContract{

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
		enterUserName(uname);
		enterPassWord(pwd);
		clickOnSubmit();
		return getErrorMessage();
	}
	
	public OrangeDashboard enterCredentials(String uname,String pwd){
		enterUserName(uname);
		enterPassWord(pwd);
		clickOnSubmit();
		
	/*	if(invalidLoginError!=null)
			return null;*/
		
		return PageFactory.initElements(AppUtility.driver, OrangeDashboard.class);
	}

	private void clickOnSubmit() {
		this.submitBtn.click();
	}

	private void enterPassWord(String pwd) {
		this.password.clear();
		this.password.sendKeys(pwd);
	}

	private void enterUserName(String uname) {
		this.userName.clear();
		this.userName.sendKeys(uname);
	}
	
	
	public void validateLoginPage(){
		Assert.assertEquals(usernameDiv.getText(), "Username");
		Assert.assertEquals(passwordDiv.getText(), "Password");
		Assert.assertNotNull(orgHeading);
		Assert.assertEquals(submitBtn.getAttribute("value"), "LOGIN");
		Assert.assertNull(invalidLoginError);
	}
	
	private String getErrorMessage(){
		if(null==invalidLoginError)
			return null;
		else
			return invalidLoginError.getText();
	}

	public boolean isPageLoaded() {
		return orgHeading!=null && submitBtn!=null;
	}
	
}
