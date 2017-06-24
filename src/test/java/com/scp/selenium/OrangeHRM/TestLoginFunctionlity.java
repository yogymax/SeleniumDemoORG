package com.scp.selenium.OrangeHRM;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.scp.selenium.OrangeHRM.AppConstants.MyBrowsers;

import junit.framework.Assert;
import orangehrm.loginpo.AppUtility;
import orangehrm.loginpo.OrangeDashboard;
import orangehrm.loginpo.OrangeHRMLogin;

public class TestLoginFunctionlity {
  Logger logger = Logger.getLogger(TestLoginFunctionlity.class);
	
	
	
  @Test
  public void validCredentials() {
	  logger.info("validCredentials");
	  OrangeHRMLogin loginPage = 
			  AppUtility.enterApplicationUrl(MyBrowsers.FIREFOX);
	 OrangeDashboard dashboardPage = loginPage.enterCredentials("Admin", "admin");
	 Assert.assertNotNull(dashboardPage);
	 Assert.assertTrue(dashboardPage.isPageLoaded());
  }
	
  @Test
  public void invalidCredentials() {
	  logger.info("invalidCredentials");
	  OrangeHRMLogin loginPage = 
			  AppUtility.enterApplicationUrl(MyBrowsers.FIREFOX);
	  
	 Assert.assertEquals(AppConstants.INVALID_CREDETIALS,
			 loginPage.checkInvalidCredentials("xyza", "asas"));
	 
  }
  
  @Test
  public void invalidUserName() {
	  logger.info("invalidUserName");
	  
	  OrangeHRMLogin loginPage = 
			  AppUtility.enterApplicationUrl(MyBrowsers.FIREFOX);
	  
	 Assert.assertEquals(AppConstants.INVALID_CREDETIALS,
			 loginPage.checkInvalidCredentials("xyza", "admin"));

  }
  
  
  @Test
  public void invalidPassword() {
	  logger.info("invalidPassword");
	  OrangeHRMLogin loginPage = 
			  AppUtility.enterApplicationUrl(MyBrowsers.FIREFOX);
	  
	 Assert.assertEquals(AppConstants.INVALID_CREDETIALS,
			 loginPage.checkInvalidCredentials("Admin", "adnsa"));

  }
  
  @Test
  public void blankPassword() {
	  logger.info("blankPassword");
	  OrangeHRMLogin loginPage = 
			  AppUtility.enterApplicationUrl(MyBrowsers.FIREFOX);
	  
	 Assert.assertEquals(AppConstants.PASSWORD_CANNOT_BE_BLANK,
			 loginPage.checkInvalidCredentials("Admin", ""));

  }
  
  
  @Test
  public void blankUserName() {
	  logger.info("blankUserName");
	  OrangeHRMLogin loginPage = 
			  AppUtility.enterApplicationUrl(MyBrowsers.FIREFOX);
	  
	 Assert.assertEquals(AppConstants.USERNAME_CANNOT_BE_BLANK,
			 loginPage.checkInvalidCredentials("", "admin"));

  }
  
  @Test
  public void blankUsernamePassword() {
	  logger.info("invalidCredentials");
	  OrangeHRMLogin loginPage = 
			  AppUtility.enterApplicationUrl(MyBrowsers.FIREFOX);
	  
	 Assert.assertEquals(AppConstants.USERNAME_CANNOT_BE_BLANK,
			 loginPage.checkInvalidCredentials("", ""));

  }
  
}
