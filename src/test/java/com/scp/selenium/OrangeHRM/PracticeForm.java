package com.scp.selenium.OrangeHRM;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticeForm {
	
	
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		File f = new File("");
		String driverpath = f.getAbsolutePath()+"\\src\\main\\java\\chromedriver.exe";
		System.out.println(driverpath);
		/*System.setProperty("webdriver.chrome.driver", driverpath);
		WebDriver driver = new ChromeDriver();*/
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		WebElement uploadFile =driver.findElement(By.id("photo"));
		uploadFile.click();
		Runtime.getRuntime().exec("C:\\Users\\Progvaltion_11\\Desktop\\Other\\AutoItDemo\\UploadMyFile.exe");
		
		
	/*	//Using Robot Class
	 	AppUtility.setDataToClipBoard("C:\\Users\\Progvaltion_11\\Desktop\\Other\\demo1.txt");
		Robot  robot = new Robot();
		Thread.sleep(2000);  // sleep has only been used to showcase each event separately	
        robot.keyPress(KeyEvent.VK_CONTROL);	
        Thread.sleep(100);	
        robot.keyPress(KeyEvent.VK_V);	
        Thread.sleep(100);	
        
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_ENTER);
		
    */    
    
		
		
	}

}
