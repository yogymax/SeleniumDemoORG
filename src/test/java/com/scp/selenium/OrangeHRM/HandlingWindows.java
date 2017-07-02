package com.scp.selenium.OrangeHRM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingWindows {
	
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();//Saving parent window identifier
		WebElement newBrowserWindowBtn =driver.findElement(By.id("button1"));
		newBrowserWindowBtn.click();

		WebElement newBrowserWindowmsg =driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/p[3]/button"));
		newBrowserWindowmsg.click();
		
		WebElement newBrowserWindowTab =driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/p[4]/button"));
		newBrowserWindowTab.click();
		
		Set<String> allWindowNames = driver.getWindowHandles();
		
		
		for (String oneWindow : allWindowNames) {
			System.out.println("Switching to Window name > "+oneWindow);
			driver.switchTo().window(oneWindow);
			driver.manage().window().maximize();
			if(!oneWindow.equals(parentWindow))
				driver.close();
		}
		driver.switchTo().window(parentWindow);
		
		
		
		
}

}